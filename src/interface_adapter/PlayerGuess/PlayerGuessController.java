package interface_adapter.PlayerGuess;

import entity.Song;
import use_case.PlayerGuess.PlayerGuessInputBoundary;
import use_case.PlayerGuess.PlayerGuessInputData;

public class PlayerGuessController {

    private PlayerGuessInputBoundary playerGuessInputBoundary;

    public PlayerGuessController(PlayerGuessInputBoundary playerGuessInputBoundary){
        this.playerGuessInputBoundary = playerGuessInputBoundary;
    }

    public void execute (Song song){
        PlayerGuessInputData playerGuessInputData = new PlayerGuessInputData(song);
        this.playerGuessInputBoundary.checkGuess(playerGuessInputData);
    }
}
