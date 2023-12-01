package use_case.ReceiveMessage;

import entity.*;

import use_case.UpdateScore.UpdateScoreInputBoundary;
import use_case.UpdateScore.UpdateScoreInputData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReceiveMessageInteractor implements ReceiveMessageInputBoundary {
    final ReceiveMessageGameStateDataAccessInterface gameStateDataAccessObject;
    final ReceiveMessageRoundStateDataAccessInterface roundStataDataAccessObject;
    final ReceiveMessageMessageHistoryDataAccessInterface messageHistoryDataAccessObject;
    final ReceiveMessagePlayerDataAccessInterface playerDataAccessObject;
    final ReceiveMessageOutputBoundary receiveMessagePresenter;
    final UpdateScoreInputBoundary updateScoreInputBoundary;

    public ReceiveMessageInteractor(ReceiveMessageGameStateDataAccessInterface gameStateDataAccessObject, ReceiveMessageRoundStateDataAccessInterface roundStataDataAccessObject, ReceiveMessageMessageHistoryDataAccessInterface messageHistoryDataAccessObject, ReceiveMessagePlayerDataAccessInterface playerDataAccessObject,
                                    ReceiveMessageOutputBoundary receiveMessagePresenter, UpdateScoreInputBoundary updateScoreInputBoundary) {
        this.gameStateDataAccessObject = gameStateDataAccessObject;
        this.roundStataDataAccessObject = roundStataDataAccessObject;
        this.messageHistoryDataAccessObject = messageHistoryDataAccessObject;
        this.playerDataAccessObject = playerDataAccessObject;
        this.receiveMessagePresenter = receiveMessagePresenter;
//        this.checkGuessInteractor = checkGuessInteractor;
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

        String singingPatternString = "(.+?) has chose a song! Start guessing!";
        Pattern singingPattern = Pattern.compile(singingPatternString);
        Matcher singingMatcher = singingPattern.matcher(content);

        String newSongPatternString = "Song: (.+?) by (.+?)";
        Pattern newSongPattern = Pattern.compile(newSongPatternString);
        Matcher newSongMatcher = newSongPattern.matcher(content);

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
        } else if (type == Message.MessageType.INVIS_SYSTEM && newSongMatcher.matches()) {
            String songTitle = newSongMatcher.group(1);
            String songArtist = newSongMatcher.group(2);

            Song song1 = new Song(songArtist, songTitle);
            roundState.setSong(song1);
        } else if (type == Message.MessageType.INVIS_SYSTEM && content.equals("ROUND DONE")) {
            roundState.setSingerState(RoundState.SingerState.DONE);
        }

        // don't show the message if the player hasn't guessed it yet, and it comes from a player who has guessed it

        boolean showMessage = type != Message.MessageType.GUESSED || roundState.getGuessStatusByPlayer(gameState.getMainPlayer());
        // don't show the message if it's an invis message
        showMessage = showMessage && type != Message.MessageType.INVIS_SYSTEM;

        ReceiveMessageOutputData receiveMessageOutputData = new ReceiveMessageOutputData(message, showMessage);
        receiveMessagePresenter.prepareSuccessView(receiveMessageOutputData);
    }
}
