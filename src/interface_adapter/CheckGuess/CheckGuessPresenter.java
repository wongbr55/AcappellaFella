package interface_adapter.CheckGuess;

import entity.Message;
import interface_adapter.Chat.ChatState;
import interface_adapter.Chat.ChatViewModel;
import use_case.CheckGuess.CheckGuessOutputBoundary;
import use_case.CheckGuess.CheckGuessOutputData;

public class CheckGuessPresenter implements CheckGuessOutputBoundary {
    private final CheckGuessViewModel checkGuessViewModel;
    private final ChatViewModel chatViewModel;

    public CheckGuessPresenter(CheckGuessViewModel checkGuessViewModel, ChatViewModel chatViewModel) {
        this.checkGuessViewModel = checkGuessViewModel;
        this.chatViewModel = chatViewModel;
    }

    @Override
    public void returnGuess(CheckGuessOutputData checkGuessOutputData) {
        // call the ChatViewModel to update the message history and pass in
        Message message = checkGuessOutputData.getMessage();
        ChatState chatState = this.chatViewModel.getState();
        String chatHistory = chatState.getMessageHistory().concat(message.toDisplayString() + "\n");
        chatState.setMessageHistory(chatHistory);
        chatViewModel.setState(chatState);
        chatViewModel.firePropertyChanged();

    }
}
