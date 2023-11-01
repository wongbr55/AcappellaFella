package interface_adapter.SendMessage;

import use_case.SendMessage.SendMessageOutputBoundary;
import use_case.SendMessage.SendMessageOutputData;

public class SendMessagePresenter implements SendMessageOutputBoundary {
    private final SendMessageLoggerModel sendMessageLoggerModel;

    public SendMessagePresenter(SendMessageLoggerModel sendMessageLoggerModel) {
        this.sendMessageLoggerModel = sendMessageLoggerModel;
    }

    @Override
    public void prepareSuccessView(SendMessageOutputData sendMessageOutputData) {
        // send message on discord
        String content = String.format("%s\n%s",
                sendMessageOutputData.getMessage().getAuthor().getName(),
                sendMessageOutputData.getMessage().getContent());
        SendMessageState state = new SendMessageState();
        state.setLastMessage(content);
        this.sendMessageLoggerModel.setState(state);
        sendMessageLoggerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        // todo
    }
}
