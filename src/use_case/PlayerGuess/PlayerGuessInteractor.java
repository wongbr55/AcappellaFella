package use_case.PlayerGuess;

import entity.GameState;

public class PlayerGuessInteractor implements PlayerGuessInputBoundary{

    private PlayerGuessDataAccessInterface playerGuessDataAccessInterface;

    private PlayerGuessOutputBoundary playerGuessOutputBoundary;

    public PlayerGuessInteractor(PlayerGuessDataAccessInterface playerGuessDataAccessInterface, PlayerGuessOutputBoundary playerGuessOutputBoundary){
        this.playerGuessDataAccessInterface = playerGuessDataAccessInterface;
        this.playerGuessOutputBoundary = playerGuessOutputBoundary;
    }

    @Override
    public void checkGuess(PlayerGuessInputData playerGuessInputData) {
        GameState state = this.playerGuessDataAccessInterface.getGameState();
        String songTitle = state.getSong().getTitle();
        String guessTitle = playerGuessInputData.getSong().getTitle();
        if (songTitle.toLowerCase().equals(guessTitle.toLowerCase())){
            PlayerGuessOutputData playerGuessOutputData = new PlayerGuessOutputData(true);
            this.playerGuessOutputBoundary.returnGuess(playerGuessOutputData);
        }
        else {
            PlayerGuessOutputData playerGuessOutputData = new PlayerGuessOutputData(false);
            this.playerGuessOutputBoundary.returnGuess(playerGuessOutputData);
        }

    }
}
