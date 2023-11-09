package interface_adapter.ReceiveMessage;

import entity.Message;
import interface_adapter.Chat.ChatState;
import interface_adapter.Chat.ChatViewModel;
import use_case.ReceiveMessage.ReceiveMessageOutputBoundary;
import use_case.ReceiveMessage.ReceiveMessageOutputData;

public class ReceiveMessagePresenter implements ReceiveMessageOutputBoundary {
    private final ChatViewModel chatViewModel;

    public ReceiveMessagePresenter(ChatViewModel chatViewModel) {
        this.chatViewModel = chatViewModel;
    }

    @Override
    public void prepareSuccessView(ReceiveMessageOutputData receiveMessageOutputData) {
        Message message = receiveMessageOutputData.getMessage();
        ChatState chatState = chatViewModel.getState();
        String chatHistory = chatState.getMessageHistory().concat(message.toDisplayString() + "\n");
        chatState.setMessageHistory(chatHistory);
        chatViewModel.setState(chatState);
        chatViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        // todo
    }
}
