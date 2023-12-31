package use_case.ReceiveMessage;

import entity.*;

import interface_adapter.AddPlayer.AddPlayerController;
import interface_adapter.RunGame.RunGameController;
import use_case.UpdateScore.UpdateScoreInputBoundary;
import use_case.UpdateScore.UpdateScoreInputData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReceiveMessageInteractor implements ReceiveMessageInputBoundary {
    final ReceiveMessageGameStateDataAccessInterface gameStateDataAccessObject;
    final ReceiveMessageRoundStateDataAccessInterface roundStataDataAccessObject;
    final ReceiveMessageMessageHistoryDataAccessInterface messageHistoryDataAccessObject;
    final ReceiveMessagePlaylistDataAccessInterface receiveMessagePlaylistDataAccessObject;
    final ReceiveMessagePlayerDataAccessInterface playerDataAccessObject;
    final AddPlayerController addPlayerController;
    final RunGameController runGameController;
    final ReceiveMessageOutputBoundary receiveMessagePresenter;
    final UpdateScoreInputBoundary updateScoreInputBoundary;

    public ReceiveMessageInteractor(ReceiveMessageGameStateDataAccessInterface gameStateDataAccessObject, ReceiveMessageRoundStateDataAccessInterface roundStataDataAccessObject, ReceiveMessageMessageHistoryDataAccessInterface messageHistoryDataAccessObject, ReceiveMessagePlaylistDataAccessInterface receiveMessagePlaylistDataAccessObject, ReceiveMessagePlayerDataAccessInterface playerDataAccessObject,
                                    AddPlayerController addPlayerController, RunGameController runGameController, ReceiveMessageOutputBoundary receiveMessagePresenter, UpdateScoreInputBoundary updateScoreInputBoundary) {
        this.gameStateDataAccessObject = gameStateDataAccessObject;
        this.roundStataDataAccessObject = roundStataDataAccessObject;
        this.messageHistoryDataAccessObject = messageHistoryDataAccessObject;
        this.receiveMessagePlaylistDataAccessObject = receiveMessagePlaylistDataAccessObject;
        this.playerDataAccessObject = playerDataAccessObject;
        this.addPlayerController = addPlayerController;
        this.runGameController = runGameController;
        this.receiveMessagePresenter = receiveMessagePresenter;
        this.updateScoreInputBoundary = updateScoreInputBoundary;
    }

    @Override
    public void execute(ReceiveMessageInputData receiveMessageInputData) {
        MessageHistory messageHistory = messageHistoryDataAccessObject.getMessageHistory();
        Player player = playerDataAccessObject.getByName(receiveMessageInputData.getAuthor());
        String content = receiveMessageInputData.getContent();
        Message.MessageType type = Message.MessageType.valueOf(receiveMessageInputData.getType());
        Message message = new Message(player, content, type);
        // add message to message history
        messageHistory.addMessage(message);
        GameState gameState = gameStateDataAccessObject.getGameState();
        RoundState roundState = roundStataDataAccessObject.getCurrentRoundState();

        String guessedPatternString = "(.+?) has guessed the answer!";
        Pattern guessedPattern = Pattern.compile(guessedPatternString);
        Matcher guessedMatcher = guessedPattern.matcher(content);

        String addPlayerPatternString = "(.+?) has joined.";
        Pattern addPlayerPattern = Pattern.compile(addPlayerPatternString);
        Matcher addPlayerMatcher = addPlayerPattern.matcher(content);

        String singingPatternString = "(.+?) has chose a song! Start guessing!";
        Pattern singingPattern = Pattern.compile(singingPatternString);
        Matcher singingMatcher = singingPattern.matcher(content);

        String newSongPatternString = "Song: (.+?) by (.+?)";
        Pattern newSongPattern = Pattern.compile(newSongPatternString);
        Matcher newSongMatcher = newSongPattern.matcher(content);

        String startGamePatternString = "GAME STARTED\n(.+?)\n(.+?)\n(.+?)";
        Pattern startGamePattern = Pattern.compile(startGamePatternString);
        Matcher startGameMatcher = startGamePattern.matcher(content);

        // if it matches
        if (type == Message.MessageType.SYSTEM && guessedMatcher.matches()) {
            String playerName = guessedMatcher.group(1);
            player = playerDataAccessObject.getByName(playerName);

            // send player info to UpdateScoreInteractor as input data
            UpdateScoreInputData updateScoreInputData = new UpdateScoreInputData(player);
            this.updateScoreInputBoundary.execute(updateScoreInputData);

            roundState.setGuessStatusByPlayer(player, true);
        } else if (type == Message.MessageType.SYSTEM && singingMatcher.matches()) {
            roundState.setSingerState(RoundState.SingerState.SINGING);
        } else if (type == Message.MessageType.SYSTEM && addPlayerMatcher.matches()) {
            // as long as it isn't yourself
            if (!gameState.getMainPlayer().getName().equals(addPlayerMatcher.group(1))) {
                addPlayerController.execute(addPlayerMatcher.group(1));
            }
        } else if (type == Message.MessageType.INVIS_SYSTEM && newSongMatcher.matches()) {
            String songTitle = newSongMatcher.group(1);
            String songArtist = newSongMatcher.group(2);

            Song song1 = new Song(songArtist, songTitle);
            roundState.setSong(song1);
        } else if (type == Message.MessageType.INVIS_SYSTEM && content.equals("ROUND DONE")) {
            roundState.setSingerState(RoundState.SingerState.DONE);
        } else if (type == Message.MessageType.INVIS_SYSTEM && startGameMatcher.matches()) {
            receiveMessagePlaylistDataAccessObject.loadPlaylist(startGameMatcher.group(3));

            int numberOfRounds = Integer.parseInt(startGameMatcher.group(1));
            int roundLength = Integer.parseInt(startGameMatcher.group(2));

            // no idea what threads do, so this is basically completely uncontrolled
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    runGameController.execute(numberOfRounds, roundLength);
                }
            });
            thread.start();
        }

        // don't show the message if the player hasn't guessed it yet, and it comes from a player who has guessed it

        boolean showMessage = type != Message.MessageType.GUESSED || roundState.getGuessStatusByPlayer(gameState.getMainPlayer());
        // don't show the message if it's an invis message
        showMessage = showMessage && type != Message.MessageType.INVIS_SYSTEM;

        ReceiveMessageOutputData receiveMessageOutputData = new ReceiveMessageOutputData(message, showMessage);
        receiveMessagePresenter.prepareSuccessView(receiveMessageOutputData);
    }
}
