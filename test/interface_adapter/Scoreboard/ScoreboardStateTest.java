package interface_adapter.Scoreboard;

import entity.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ScoreboardStateTest {
    ScoreboardState scoreboardState;
    @Before
    public void init() {
        scoreboardState = new ScoreboardState();
        Player playerA = new Player();
        playerA.setName("A");
        Player playerB = new Player();
        playerB.setName("B");
        scoreboardState.addPlayer(playerA.getName());
        scoreboardState.addPlayer(playerB.getName());
    }

    @Test
    public void testGetScoreboard() {
        assertTrue(this.scoreboardState.getScoreboard().containsKey("A"));
        assertTrue(this.scoreboardState.getScoreboard().containsKey("B"));
    }

    @Test
    public void setScoreboard() {
        Map<String, Integer> newScoreboard = new HashMap<>();
        this.scoreboardState.setScoreboard(newScoreboard);
        assertFalse(this.scoreboardState.getScoreboard().containsKey("A"));

    }

    @Test
    public void addPlayer() {
        Player playerC = new Player();
        playerC.setName("C");
        this.scoreboardState.addPlayer(playerC.getName());
        assertTrue(this.scoreboardState.getScoreboard().containsKey("C"));
    }
}