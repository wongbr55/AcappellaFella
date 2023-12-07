package data_access;

import entity.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InMemoryScoreboardScoreboardDataAccessObjectTest {
    InMemoryScoreboardScoreboardDataAccessObject scoreboardScoreboardDataAccessObject;
    @Before
    public void setUp() throws Exception {
        scoreboardScoreboardDataAccessObject = new InMemoryScoreboardScoreboardDataAccessObject();
        Player player = new Player();
        player.setName("A");
        scoreboardScoreboardDataAccessObject.getScoreboard().addPlayer(player);
    }

    @Test
    public void getScoreboard() {
        assertNotNull(this.scoreboardScoreboardDataAccessObject.getScoreboard());
    }

    @Test
    public void addPlayer() {
        Player newPlayer = new Player();
        newPlayer.setName("B");
        this.scoreboardScoreboardDataAccessObject.getScoreboard().addPlayer(newPlayer);
        assertEquals(0, (int) this.scoreboardScoreboardDataAccessObject.getScoreboard().getPlayerScore(newPlayer));
    }
}