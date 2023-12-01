package entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameStateTest {

    private Player mainPlayer;
    private Player sidePlayer;
    private GameState gameState;
    @Before
    public void setUp() throws Exception {
        this.gameState = new GameState();
        this.mainPlayer = new Player();
        this.mainPlayer.setName("Main Player");
        this.gameState.setMainPlayer(mainPlayer);
        this.sidePlayer = new Player();
        this.sidePlayer.setName("Side Player");

        this.gameState.setId("1234");
    }

    @Test
    public void getId() {
        assertEquals("1234", this.gameState.getId());
    }

    @Test
    public void setId() {
        this.gameState.setId("4321");
        assertEquals("4321", this.gameState.getId());
    }

    @Test
    public void getMainPlayer() {
        assertEquals(this.mainPlayer.getName(), this.gameState.getMainPlayer().getName());
    }

    @Test
    public void setMainPlayer() {
        this.gameState.setMainPlayer(sidePlayer);
        assertEquals(this.sidePlayer.getName(), this.gameState.getMainPlayer().getName());
    }

}