package use_case.CheckGuess;

import entity.GameState;
import entity.Message;

public class CheckGuessInteractor implements CheckGuessInputBoundary {
    private final CheckGuessDataAccessInterface checkGuessDataAccessInterface;

    private final CheckGuessOutputBoundary checkGuessOutputBoundary;

    public CheckGuessInteractor(CheckGuessDataAccessInterface checkGuessDataAccessInterface, CheckGuessOutputBoundary checkGuessOutputBoundary) {
        this.checkGuessDataAccessInterface = checkGuessDataAccessInterface;
        this.checkGuessOutputBoundary = checkGuessOutputBoundary;
    }

    @Override
    public void execute(CheckGuessInputData checkGuessInputData) {
        GameState state = this.checkGuessDataAccessInterface.getGameState();
        String songTitle = state.getSong().getTitle();
        String guessTitle = checkGuessInputData.getSong();
        if (songTitle.equalsIgnoreCase(guessTitle) && !state.getMainPlayer().guessStatus()) {
            state.getMainPlayer().setScore(state.getMainPlayer().getScore() + 1);
            // the score system needs to be more complicated, this is left here as a placeholder
            state.getMainPlayer().hasGuessedTrue();
            Message message = new Message(state.getHost(), state.getMainPlayer().getName() + " has guessed the answer! They now have "
                    + state.getMainPlayer().getScore() + " point(s)!");
            CheckGuessOutputData checkGuessOutputData = new CheckGuessOutputData(message);
            this.checkGuessOutputBoundary.returnGuess(checkGuessOutputData);
        }

    }
}
