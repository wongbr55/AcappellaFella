package data_access;

import entity.GameState;
import entity.Player;
import use_case.CheckGuess.CheckGuessGameStateDataAccessInterface;
import use_case.ReceiveMessage.ReceiveMessageGameStateDataAccessInterface;
import use_case.SendMessage.SendMessageMainPlayerDataAccessInterface;
import use_case.SingerChoose.SingerChooseGameStateDataAccessInterface;

public class InMemoryGameStateGameStateDataAccessObject implements SingerChooseGameStateDataAccessInterface, SendMessageMainPlayerDataAccessInterface, CheckGuessGameStateDataAccessInterface, ReceiveMessageGameStateDataAccessInterface {
    private final GameState gameState = new GameState();

    @Override
    public GameState getGameState() {
        return gameState;
    }

    @Override
    public Player getMainPlayer() {
        return gameState.getMainPlayer();
    }

    public void addPlayer(Player player) {
        gameState.addPlayer(player);
    }
}
