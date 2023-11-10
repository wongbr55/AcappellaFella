package use_case.CheckGuess;

public class CheckGuessInputData {
    private final String guess;

    public CheckGuessInputData(String song) {
        this.guess = song;
    }

    public String getGuess() {
        return this.guess;
    }


}
