package use_case.ReceiveMessage;

import entity.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReceiveMessageInteractor implements ReceiveMessageInputBoundary {
    final ReceiveMessageGameStateDataAccessInterface gameStateDataAccessObject;
    final ReceiveMessageRoundStateDataAccessInterface roundStataDataAccessObject;
    final ReceiveMessageMessageHistoryDataAccessInterface messageHistoryDataAccessObject;
    final ReceiveMessagePlayerDataAccessInterface playerDataAccessObject;
    final ReceiveMessageOutputBoundary receiveMessagePresenter;

    public ReceiveMessageInteractor(ReceiveMessageGameStateDataAccessInterface gameStateDataAccessObject, ReceiveMessageRoundStateDataAccessInterface roundStataDataAccessObject, ReceiveMessageMessageHistoryDataAccessInterface messageHistoryDataAccessObject, ReceiveMessagePlayerDataAccessInterface playerDataAccessObject,
                                    ReceiveMessageOutputBoundary receiveMessagePresenter) {
        this.gameStateDataAccessObject = gameStateDataAccessObject;
        this.roundStataDataAccessObject = roundStataDataAccessObject;
        this.messageHistoryDataAccessObject = messageHistoryDataAccessObject;
        this.playerDataAccessObject = playerDataAccessObject;
        this.receiveMessagePresenter = receiveMessagePresenter;
//        this.checkGuessInteractor = checkGuessInteractor;
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

        String patternString = "(.+?) has guessed the answer!";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(content);

        // if it matches
        if (type == Message.MessageType.SYSTEM && matcher.matches()) {
            String playerName = matcher.group(1);

            // todo more updateScore use case
            player.setScore(gameState.getMainPlayer().getScore() + 1);
            roundState.setGuessStatusByPlayer(player, true);
        }

        // don't show the message if the player hasn't guess it yet and it comes from a player who has guessed it
        boolean showMessage = type != Message.MessageType.GUESSED || roundState.getGuessStatusByPlayer(gameState.getMainPlayer());

        ReceiveMessageOutputData receiveMessageOutputData = new ReceiveMessageOutputData(message, showMessage);
        receiveMessagePresenter.prepareSuccessView(receiveMessageOutputData);
    }

    public static void main(String[] args) {
        String patternString = "SYSTEM\\nSYSTEM\\n(.+?) has guessed the answer!";
        String inputString = "SYSTEM\nSYSTEM\nWAhasdzmaksdl asldkjaskldjalksd has guessed the answer!";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(inputString);

        if (matcher.matches()) {
            String playerName = matcher.group(1);
            System.out.println("Player Name: " + playerName);
        } else {
            System.out.println("String does not match the pattern");
        }
    }
}
