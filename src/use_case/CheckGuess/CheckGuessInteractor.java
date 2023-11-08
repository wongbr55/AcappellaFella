package use_case.CheckGuess;

import entity.GameState;

public class CheckGuessInteractor implements CheckGuessInputBoundary {
    private final CheckGuessDataAccessInterface checkGuessDataAccessInterface;

    private final CheckGuessOutputBoundary checkGuessOutputBoundary;

    public CheckGuessInteractor(CheckGuessDataAccessInterface checkGuessDataAccessInterface, CheckGuessOutputBoundary checkGuessOutputBoundary) {
        this.checkGuessDataAccessInterface = checkGuessDataAccessInterface;
        this.checkGuessOutputBoundary = checkGuessOutputBoundary;
    }

    @Override
    public void checkGuess(CheckGuessInputData checkGuessInputData) {
        GameState state = this.checkGuessDataAccessInterface.getGameState();
        String songTitle = state.getSong().getTitle();
        String guessTitle = checkGuessInputData.getSong();
        if (songTitle.equalsIgnoreCase(guessTitle)) {
            state.getMainPlayer().setScore(state.getMainPlayer().getScore() + 1);
            CheckGuessOutputData checkGuessOutputData = new CheckGuessOutputData(true);
            this.checkGuessOutputBoundary.returnGuess(checkGuessOutputData);
        } else {
            CheckGuessOutputData checkGuessOutputData = new CheckGuessOutputData(false);
            this.checkGuessOutputBoundary.returnGuess(checkGuessOutputData);
        }

    }
}
