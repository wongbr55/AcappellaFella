package interface_adapter.SendMessage;

import MessageLogger.MessageLogger;
import entity.MessageHistory;
import use_case.SendMessage.SendMessageOutputBoundary;
import use_case.SendMessage.SendMessageOutputData;

public class SendMessagePresenter implements SendMessageOutputBoundary {
    private final MessageLogger messageLogger;

    public SendMessagePresenter(MessageLogger messageLogger) {
        this.messageLogger = messageLogger;
    }

    @Override
    public void prepareSuccessView(SendMessageOutputData sendMessageOutputData) {
        // send message on discord
        String content = String.format("%s\n%s",
                sendMessageOutputData.getMessage().getAuthor(),
                sendMessageOutputData.getMessage().getContent());
        messageLogger.sendMessage(content);

        MessageHistory messageHistory = sendMessageOutputData.getMessageHistory();
        // todo update text messages view
    }

    @Override
    public void prepareFailView(String error) {
        // todo
    }
}
