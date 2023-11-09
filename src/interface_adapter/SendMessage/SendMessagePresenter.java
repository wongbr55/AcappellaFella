package interface_adapter.SendMessage;

import entity.Message;
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
        SendMessageState state = new SendMessageState();
        Message message = sendMessageOutputData.getMessage();
        String lastMessage = String.format("%s\n%s\n%s", message.getType(), (message.getAuthor() != null) ? message.getAuthor().getName() : "SYSTEM", message.getContent());
        state.setLastMessage(lastMessage);
        this.sendMessageLoggerModel.setState(state);
        sendMessageLoggerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        // todo
    }
}
