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
        if (checkGuessOutputData.checkCorrect()) {
            CheckGuessState state = this.checkGuessViewModel.getState();
            state.setTitleLabel("That is correct!");
            state.setHasGuessed(true);

            Message message = checkGuessOutputData.getMessage();
            ChatState chatState = this.chatViewModel.getState();
            String chatHistory = chatState.getMessageHistory().concat(message.toDisplayString() + "\n");
            chatState.setMessageHistory(chatHistory);
            chatViewModel.setState(chatState);
            chatViewModel.firePropertyChanged();
            // change the state of the view model and fire a property change
            this.checkGuessViewModel.setState(state);
            this.checkGuessViewModel.firePropertyChanged();

            // call the ChatViewModel to update the message history and pass in

        } else {
            CheckGuessState state = this.checkGuessViewModel.getState();
            state.setTitleLabel("Incorrect! Guess again...");
            // change the state of the view model and fire a property change
            this.checkGuessViewModel.setState(state);
            this.checkGuessViewModel.firePropertyChanged();
        }
    }
}
