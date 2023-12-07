package view;

import interface_adapter.Scoreboard.ScoreboardViewModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScoreboardViewTest {

    private ScoreboardView scoreboardView;
    private ScoreboardViewModel scoreboardViewModel;
    @Before
    public void setUp() {
        scoreboardViewModel = new ScoreboardViewModel();
        scoreboardViewModel.getState().addPlayer("Brandon");
        scoreboardView = new ScoreboardView(scoreboardViewModel);
    }

    @Test
    public void propertyChange() {
        scoreboardViewModel.getState().addPlayer("Mark");
        scoreboardViewModel.firePropertyChanged();
    }
}