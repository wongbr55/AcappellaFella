package use_case.PlayerGuess;

import entity.GameState;

public class PlayerGuessInteractor implements PlayerGuessInputBoundary {
    private final PlayerGuessDataAccessInterface playerGuessDataAccessInterface;

    private final PlayerGuessOutputBoundary playerGuessOutputBoundary;

    public PlayerGuessInteractor(PlayerGuessDataAccessInterface playerGuessDataAccessInterface, PlayerGuessOutputBoundary playerGuessOutputBoundary) {
        this.playerGuessDataAccessInterface = playerGuessDataAccessInterface;
        this.playerGuessOutputBoundary = playerGuessOutputBoundary;
    }

    @Override
    public void checkGuess(PlayerGuessInputData playerGuessInputData) {
        GameState state = this.playerGuessDataAccessInterface.getGameState();
        String songTitle = state.getSong().getTitle();
        String guessTitle = playerGuessInputData.getSong();
        if (songTitle.equalsIgnoreCase(guessTitle)) {
            state.getMainPlayer().setScore(state.getMainPlayer().getScore() + 1);
            PlayerGuessOutputData playerGuessOutputData = new PlayerGuessOutputData(true);
            this.playerGuessOutputBoundary.returnGuess(playerGuessOutputData);
        } else {
            PlayerGuessOutputData playerGuessOutputData = new PlayerGuessOutputData(false);
            this.playerGuessOutputBoundary.returnGuess(playerGuessOutputData);
        }

    }
}
