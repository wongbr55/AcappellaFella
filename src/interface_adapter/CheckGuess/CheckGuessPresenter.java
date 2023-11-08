package interface_adapter.CheckGuess;

import interface_adapter.ViewManagerModel;
import use_case.CheckGuess.CheckGuessOutputBoundary;
import use_case.CheckGuess.CheckGuessOutputData;

public class CheckGuessPresenter implements CheckGuessOutputBoundary {
    private final CheckGuessViewModel checkGuessViewModel;
    private final ViewManagerModel viewManagerModel;

    public CheckGuessPresenter(CheckGuessViewModel checkGuessViewModel, ViewManagerModel viewManagerModel) {
        this.checkGuessViewModel = checkGuessViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void returnGuess(CheckGuessOutputData checkGuessOutputData) {
        if (checkGuessOutputData.checkCorrect()) {
            CheckGuessState state = this.checkGuessViewModel.getState();
            state.setTitleLabel("That is correct!");
            // change the state of the view model and fire a property change
            this.checkGuessViewModel.setState(state);
            this.checkGuessViewModel.firePropertyChanged();

            this.viewManagerModel.firePropertyChanged();
            this.viewManagerModel.setActiveView(checkGuessViewModel.getViewName());
        } else {
            CheckGuessState state = this.checkGuessViewModel.getState();
            state.setTitleLabel("Incorrect! Guess again...");
            // change the state of the view model and fire a property change
            this.checkGuessViewModel.setState(state);
            this.checkGuessViewModel.firePropertyChanged();

            this.viewManagerModel.firePropertyChanged();
            this.viewManagerModel.setActiveView(checkGuessViewModel.getViewName());

        }
    }
}
