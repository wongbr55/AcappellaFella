package data_access;

import entity.GameState;
import use_case.SingerChoose.SingerChooseGameStateDataAccessInterface;

public class InMemoryGameStateGameStateDataAccessObject implements SingerChooseGameStateDataAccessInterface {
    private final GameState gameState = new GameState();
    @Override
    public GameState getGameState() {
        return gameState;
    }
}
