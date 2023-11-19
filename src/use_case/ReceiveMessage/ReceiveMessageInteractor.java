package use_case.ReceiveMessage;

import entity.*;
import use_case.UpdateScore.UpdateScoreInputBoundary;
import use_case.UpdateScore.UpdateScoreInputData;

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

        // send MESSAGE to UPDATE SCORE INTERACTOR AS INPUT DATA
        UpdateScoreInputData updateScoreInputData = new UpdateScoreInputData(message);
        this.updateScoreInputBoundary.execute(updateScoreInputData);


        GameState gameState = gameStateDataAccessObject.getGameState();
        RoundState roundState = roundStataDataAccessObject.getCurrentRoundState();

        // don't show the message if the player hasn't guess it yet and it comes from a player who has guessed it
        boolean showMessage = type != Message.MessageType.GUESSED || roundState.getGuessStatusByPlayer(gameState.getMainPlayer());

        ReceiveMessageOutputData receiveMessageOutputData = new ReceiveMessageOutputData(message, showMessage);
        receiveMessagePresenter.prepareSuccessView(receiveMessageOutputData);
    }
}
