package data_access;

import entity.GameState;
import entity.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InMemoryGameStateDataAccessObjectTest {

    private InMemoryGameStateDataAccessObject gameStateDAO;
    @Before
    public void setUp() {
        gameStateDAO = new InMemoryGameStateDataAccessObject();
    }

    @Test
    public void getGameState() {
        GameState gameState = gameStateDAO.getGameState();
    }

    @Test
    public void getMainPlayer() {
        Player player = new Player();
        player.setName("Player");
        gameStateDAO.getGameState().setMainPlayer(player);

        assertEquals(player.getName(), gameStateDAO.getMainPlayer().getName());
    }

    @Test
    public void addPlayer() {
        Player player = new Player();
        player.setName("Player");
        gameStateDAO.addPlayer(player);
    }
}