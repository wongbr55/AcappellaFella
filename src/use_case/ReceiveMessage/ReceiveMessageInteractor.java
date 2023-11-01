package use_case.ReceiveMessage;

import entity.Message;
import entity.MessageHistory;
import entity.Player;
import use_case.SendMessage.SendMessageOutputData;

public class ReceiveMessageInteractor implements ReceiveMessageInputBoundary {
    final ReceiveMessageMessageHistoryDataAccessInterface messageHistoryDataAccessObject;
    final ReceiveMessagePlayerDataAccessInterface playerDataAccessObject;
    final ReceiveMessageOutputBoundary receiveMessagePresenter;

    public ReceiveMessageInteractor(ReceiveMessageMessageHistoryDataAccessInterface messageHistoryDataAccessObject, ReceiveMessagePlayerDataAccessInterface playerDataAccessObject, ReceiveMessageOutputBoundary receiveMessagePresenter) {
        this.messageHistoryDataAccessObject = messageHistoryDataAccessObject;
        this.playerDataAccessObject = playerDataAccessObject;
        this.receiveMessagePresenter = receiveMessagePresenter;
    }

    @Override
    public void execute(ReceiveMessageInputData receiveMessageInputData) {
        MessageHistory messageHistory = messageHistoryDataAccessObject.getMessageHistory();
        Player player = playerDataAccessObject.getByName(receiveMessageInputData.getAuthor());
        Message message = new Message(player, receiveMessageInputData.getContent());

        // add message to message history
        messageHistory.addMessage(message);
        ReceiveMessageOutputData receiveMessageOutputData = new ReceiveMessageOutputData(message);
        receiveMessagePresenter.prepareSuccessView(receiveMessageOutputData);
    }
}
