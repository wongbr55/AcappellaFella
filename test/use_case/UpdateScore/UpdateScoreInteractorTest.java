package use_case.UpdateScore;

import data_access.InMemoryRoundStateDataAccessObject;
import data_access.InMemoryScoreboardScoreboardDataAccessObject;
import entity.Player;
import entity.RoundState;
import entity.Scoreboard;
import interface_adapter.Scoreboard.ScoreboardViewModel;
import interface_adapter.UpdateScore.UpdateScorePresenter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UpdateScoreInteractorTest {

    private InMemoryRoundStateDataAccessObject roundStateDataAccessObject;
    private InMemoryScoreboardScoreboardDataAccessObject scoreboardScoreboardDataAccessObject;

    private UpdateScoreInteractor updateScoreInteractor;

    private UpdateScorePresenter updateScorePresenter;
    @Before
    public void init() {
        this.roundStateDataAccessObject = new InMemoryRoundStateDataAccessObject();
        ;
        this.scoreboardScoreboardDataAccessObject = new InMemoryScoreboardScoreboardDataAccessObject();
        ScoreboardViewModel scoreboardViewModel = new ScoreboardViewModel();
        this.updateScorePresenter = new UpdateScorePresenter(scoreboardViewModel);
        this.updateScoreInteractor = new UpdateScoreInteractor(scoreboardScoreboardDataAccessObject, roundStateDataAccessObject, updateScorePresenter);

    }

    @Test
    public void execute() {
        // Instantiate two player, score = 0 by default
        Player playerA = new Player();
        playerA.setName("Mark");
        Player playerB = new Player();
        playerB.setName("Bark");

        // Add player to Scoreboard
        Scoreboard scoreboard = scoreboardScoreboardDataAccessObject.getScoreboard();
        scoreboard.addPlayer(playerA);
        scoreboard.addPlayer(playerB);

        // player A guesses right
        roundStateDataAccessObject.addRound();
        RoundState roundState = roundStateDataAccessObject.getCurrentRoundState();
        roundState.setGuessStatusByPlayer(playerA, true);
        roundState.setGuessStatusByPlayer(playerB, false);

        // execute
        UpdateScoreInputData updateScoreInputData = new UpdateScoreInputData(playerA);
        this.updateScoreInteractor.execute(updateScoreInputData);
        int newScore = this.scoreboardScoreboardDataAccessObject.getScoreboard().getPlayerScore(playerA);
        assertEquals(1, newScore);
    }
}