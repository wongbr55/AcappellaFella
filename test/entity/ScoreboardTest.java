package entity;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class ScoreboardTest {

    private Scoreboard scoreboard;
    private Player playerA;
    private Player playerB;

    @Before
    public void init(){
        scoreboard = new Scoreboard();

        playerA = new Player();
        playerA.setName("Mark");

        playerB = new Player();
        playerB.setName("Brandon");

        scoreboard.addPlayer(playerA);
        scoreboard.addPlayer(playerB);
    }

    @Test
    public void testAddPlayer() {
        Player playerC = new Player();
        playerC.setName("Shiyan");
        scoreboard.addPlayer(playerC);
        assertTrue(scoreboard.getPlayerScore(playerC) != -1);
    }

    @Test
    public void testGetPlayerScore() {
        assertEquals(0, (int) scoreboard.getPlayerScore(playerA));
    }

    @Test
    public void testUpdatePlayerScore() {
        scoreboard.updatePlayerScore(playerA, 5);
        assertEquals(5, (int) scoreboard.getPlayerScore(playerA));
    }

    @Test
    public void getNumberOfPlayers() {
        assertEquals(2, (int) scoreboard.getNumberOfPlayers());
    }
}