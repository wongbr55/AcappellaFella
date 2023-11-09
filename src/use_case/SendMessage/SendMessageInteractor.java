package use_case.SendMessage;

import entity.Message;
import entity.Player;

public class SendMessageInteractor implements SendMessageInputBoundary {
    final SendMessageMainPlayerDataAccessInterface mainPlayerDataAccessObject;
    final SendMessageOutputBoundary sendMessagePresenter;

    public SendMessageInteractor(SendMessageMainPlayerDataAccessInterface mainPlayerDataAccessObject,
                                 SendMessageOutputBoundary sendMessagePresenter) {
        this.mainPlayerDataAccessObject = mainPlayerDataAccessObject;
        this.sendMessagePresenter = sendMessagePresenter;
    }

    @Override
    public void execute(SendMessageInputData sendMessageInputData) {
        Player author = sendMessageInputData.getAuthor();
        String content = sendMessageInputData.getMessage();
        Message message = new Message(author, content);
        SendMessageOutputData sendMessageOutputData = new SendMessageOutputData(message);
        sendMessagePresenter.prepareSuccessView(sendMessageOutputData);
    }
}
