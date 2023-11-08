package use_case.PlayerGuess;

public class PlayerGuessOutputData {
    private final boolean guessIsCorrect;

    public PlayerGuessOutputData(boolean guessIsCorrect) {
        this.guessIsCorrect = guessIsCorrect;
    }

    public boolean checkCorrect() {
        return this.guessIsCorrect;
    }

}
