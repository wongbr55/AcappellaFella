package interface_adapter.UpdateScore;

import entity.Player;
import entity.Scoreboard;
import interface_adapter.Scoreboard.ScoreboardViewModel;
import org.junit.Before;
import org.junit.Test;
import use_case.UpdateScore.UpdateScoreOutputData;

import java.util.Map;

import static org.junit.Assert.*;

public class UpdateScorePresenterTest {

    private UpdateScorePresenter updateScorePresenter;
    private ScoreboardViewModel scoreboardViewModel;

    @Before
    public void setUp() {
        scoreboardViewModel = new ScoreboardViewModel();
        updateScorePresenter = new UpdateScorePresenter(scoreboardViewModel);
    }

    @Test
    public void prepareSuccessView() {
        Player player = new Player();
        player.setName("A");
        UpdateScoreOutputData updateScoreOutputData = new UpdateScoreOutputData(player, 10);
        this.updateScorePresenter.prepareSuccessView(updateScoreOutputData);
    }
}