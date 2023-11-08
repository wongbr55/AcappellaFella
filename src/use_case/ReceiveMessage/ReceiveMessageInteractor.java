package use_case.ReceiveMessage;

import entity.Message;
import entity.MessageHistory;
import entity.Player;
import use_case.PlayerGuess.PlayerGuessInputData;
import use_case.PlayerGuess.PlayerGuessInteractor;

public class ReceiveMessageInteractor implements ReceiveMessageInputBoundary {
    final ReceiveMessageMessageHistoryDataAccessInterface messageHistoryDataAccessObject;
    final ReceiveMessagePlayerDataAccessInterface playerDataAccessObject;
    final ReceiveMessageOutputBoundary receiveMessagePresenter;
    final PlayerGuessInteractor playerGuessInteractor;

    public ReceiveMessageInteractor(ReceiveMessageMessageHistoryDataAccessInterface messageHistoryDataAccessObject, ReceiveMessagePlayerDataAccessInterface playerDataAccessObject,
                                    ReceiveMessageOutputBoundary receiveMessagePresenter, PlayerGuessInteractor playerGuessInteractor) {
        this.messageHistoryDataAccessObject = messageHistoryDataAccessObject;
        this.playerDataAccessObject = playerDataAccessObject;
        this.receiveMessagePresenter = receiveMessagePresenter;
        this.playerGuessInteractor = playerGuessInteractor;
    }

    @Override
    public void execute(ReceiveMessageInputData receiveMessageInputData) {
        MessageHistory messageHistory = messageHistoryDataAccessObject.getMessageHistory();
        Player player = playerDataAccessObject.getByName(receiveMessageInputData.getAuthor());
        Message message = new Message(player, receiveMessageInputData.getContent());

        // call the PlayerGuess use case
        PlayerGuessInputData playerGuessInputData = new PlayerGuessInputData(receiveMessageInputData.getContent(), player.getName());
        this.playerGuessInteractor.checkGuess(playerGuessInputData);


        // add message to message history
        messageHistory.addMessage(message);
        ReceiveMessageOutputData receiveMessageOutputData = new ReceiveMessageOutputData(message);
        receiveMessagePresenter.prepareSuccessView(receiveMessageOutputData);
    }
}
