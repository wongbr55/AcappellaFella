package use_case.SendMessage;

import entity.Message;
import entity.MessageHistory;

public class SendMessageInteractor implements SendMessageInputBoundary {
    final SendMessageMessageHistoryDataAccessInterface messageHistoryDataAccessObject;
    final SendMessageOutputBoundary sendMessagePresenter;

    public SendMessageInteractor(SendMessageMessageHistoryDataAccessInterface messageHistoryDataAccessObject, SendMessageOutputBoundary sendMessagePresenter) {
        this.messageHistoryDataAccessObject = messageHistoryDataAccessObject;
        this.sendMessagePresenter = sendMessagePresenter;
    }

    @Override
    public void execute(SendMessageInputData sendMessageInputData) {
        MessageHistory messageHistory = messageHistoryDataAccessObject.getMessageHistory();
        Message message = sendMessageInputData.getMessage();
        // add message to message history
        messageHistory.addMessage(message);
        SendMessageOutputData sendMessageOutputData = new SendMessageOutputData(message, messageHistory);
        sendMessagePresenter.prepareSuccessView(sendMessageOutputData);
    }
}
