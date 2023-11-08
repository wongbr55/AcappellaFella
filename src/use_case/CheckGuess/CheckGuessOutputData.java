package use_case.CheckGuess;

public class CheckGuessOutputData {
    private final boolean guessIsCorrect;

    public CheckGuessOutputData(boolean guessIsCorrect) {
        this.guessIsCorrect = guessIsCorrect;
    }

    public boolean checkCorrect() {
        return this.guessIsCorrect;
    }

}
