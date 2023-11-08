package use_case.CheckGuess;

import entity.Message;

public class CheckGuessOutputData {
    private final boolean guessIsCorrect;
    private Message message;

    public CheckGuessOutputData(boolean guessIsCorrect) {
        this.guessIsCorrect = guessIsCorrect;
    }

    public CheckGuessOutputData(boolean guessIsCorrect, Message message) {
        this.guessIsCorrect = guessIsCorrect;
        this.message = message;
    }

    public boolean checkCorrect() {
        return this.guessIsCorrect;
    }

    public Message getMessage() {
        return message;
    }
}
