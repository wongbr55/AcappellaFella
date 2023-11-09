package interface_adapter.CheckGuess;

import use_case.CheckGuess.CheckGuessInputBoundary;
import use_case.CheckGuess.CheckGuessInputData;

public class CheckGuessController {
    private final CheckGuessInputBoundary checkGuessInputBoundary;

    public CheckGuessController(CheckGuessInputBoundary checkGuessInputBoundary) {
        this.checkGuessInputBoundary = checkGuessInputBoundary;
    }


    public void checkGuess(String guess) {
        CheckGuessInputData checkGuessInputData = new CheckGuessInputData(guess);
        this.checkGuessInputBoundary.execute(checkGuessInputData);
    }
}
