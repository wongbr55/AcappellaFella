package interface_adapter.PlayerGuess;

import interface_adapter.ViewManagerModel;
import use_case.PlayerGuess.PlayerGuessOutputBoundary;
import use_case.PlayerGuess.PlayerGuessOutputData;

public class PlayerGuessPresenter implements PlayerGuessOutputBoundary {
    private final PlayerGuessViewModel playerGuessViewModel;
    private final ViewManagerModel viewManagerModel;

    public PlayerGuessPresenter(PlayerGuessViewModel playerGuessViewModel, ViewManagerModel viewManagerModel) {
        this.playerGuessViewModel = playerGuessViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void returnGuess(PlayerGuessOutputData playerGuessOutputData) {
        if (playerGuessOutputData.checkCorrect()) {
            PlayerGuessState state = this.playerGuessViewModel.getState();
            state.setTitleLabel("That is correct!");
            // change the state of the view model and fire a property change
            this.playerGuessViewModel.setState(state);
            this.playerGuessViewModel.firePropertyChanged();

            this.viewManagerModel.firePropertyChanged();
            this.viewManagerModel.setActiveView(playerGuessViewModel.getViewName());
        } else {
            PlayerGuessState state = this.playerGuessViewModel.getState();
            state.setTitleLabel("Incorrect! Guess again...");
            // change the state of the view model and fire a property change
            this.playerGuessViewModel.setState(state);
            this.playerGuessViewModel.firePropertyChanged();

            this.viewManagerModel.firePropertyChanged();
            this.viewManagerModel.setActiveView(playerGuessViewModel.getViewName());

        }
    }
}
