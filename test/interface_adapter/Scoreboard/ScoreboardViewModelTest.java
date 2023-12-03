package interface_adapter.Scoreboard;

import entity.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScoreboardViewModelTest {

    ScoreboardViewModel scoreboardViewModel;
    @Before
    public void init() {
        scoreboardViewModel = new ScoreboardViewModel();
        Player playerA = new Player();
        playerA.setName("A");
        Player playerB = new Player();
        playerB.setName("B");
        scoreboardViewModel.getState().addPlayer(playerA.getName());
        scoreboardViewModel.getState().addPlayer(playerB.getName());
    }

    @Test
    public void firePropertyChanged() {
    }

    @Test
    public void addPropertyChangeListener() {
    }

    @Test
    public void getState() {
        assertTrue(this.scoreboardViewModel.getState().getScoreboard().containsKey("A"));
        assertTrue(this.scoreboardViewModel.getState().getScoreboard().containsKey("B"));
    }

    @Test
    public void setState() {
        ScoreboardState newState = new ScoreboardState();
        this.scoreboardViewModel.setState(newState);
        assertFalse(this.scoreboardViewModel.getState().getScoreboard().containsKey("A"));
    }
}