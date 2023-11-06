package interface_adapter.PlayerGuess;

import interface_adapter.ViewManagerModel;
import use_case.PlayerGuess.PlayerGuessOutputBoundary;
import use_case.PlayerGuess.PlayerGuessOutputData;

public class PlayerGuessPresenter implements PlayerGuessOutputBoundary {

    private PlayerGuessViewModel playerGuessViewModel;
    private ViewManagerModel viewManagerModel;
    public PlayerGuessPresenter(PlayerGuessViewModel playerGuessViewModel, ViewManagerModel viewManagerModel){
        this.playerGuessViewModel = playerGuessViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void returnGuess(PlayerGuessOutputData playerGuessOutputData) {
        if (playerGuessOutputData.checkCorrect()){
            PlayerGuessState state = this.playerGuessViewModel.getState();
            state.setTitle_label("That is correct!");
            this.playerGuessViewModel.setState(state);
            this.viewManagerModel.setActiveView(playerGuessViewModel.getViewName());
            this.viewManagerModel.firePropertyChanged();


        }else{
            PlayerGuessState state = this.playerGuessViewModel.getState();
            state.setTitle_label("Incorrect! Guess again...");
            this.playerGuessViewModel.setState(state);
            this.viewManagerModel.setActiveView(playerGuessViewModel.getViewName());
            this.viewManagerModel.firePropertyChanged();
        }

    }
}
