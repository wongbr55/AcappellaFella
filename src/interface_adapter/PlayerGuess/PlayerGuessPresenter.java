package interface_adapter.PlayerGuess;

import use_case.PlayerGuess.PlayerGuessOutputBoundary;
import use_case.PlayerGuess.PlayerGuessOutputData;

public class PlayerGuessPresenter implements PlayerGuessOutputBoundary {

    private PlayerGuessViewModel playerGuessViewModel;
    public PlayerGuessPresenter(PlayerGuessViewModel playerGuessViewModel){
        this.playerGuessViewModel = playerGuessViewModel;
    }

    @Override
    public void returnGuess(PlayerGuessOutputData playerGuessOutputData) {

    }
}
