package view;

import interface_adapter.Scoreboard.ScoreboardViewModel;
import interface_adapter.SingerSing.SingerSingViewModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SingerSingViewTest {

    private SingerSingView singerSingView;
    private SingerSingViewModel singerSingViewModel;
    @Before
    public void setUp() throws Exception {
        singerSingViewModel = new SingerSingViewModel();
        ScoreboardViewModel scoreboardViewModel = new ScoreboardViewModel();
        ScoreboardView scoreboardView = new ScoreboardView(scoreboardViewModel);
        singerSingView = new SingerSingView(scoreboardView, singerSingViewModel);
    }

    @Test
    public void propertyChange() {
        singerSingViewModel.getState().setSongLabel("hello");
        singerSingViewModel.firePropertyChanged();

        assertEquals("hello", singerSingView.getSong().getText());
    }
}