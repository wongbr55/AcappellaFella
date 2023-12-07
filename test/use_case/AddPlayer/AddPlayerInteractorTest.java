package use_case.AddPlayer;

import data_access.InMemoryGameStateDataAccessObject;
import data_access.InMemoryPlayerDataAccessObject;
import data_access.InMemoryScoreboardScoreboardDataAccessObject;
import entity.Player;
import interface_adapter.Scoreboard.ScoreboardViewModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddPlayerInteractorTest {

    private AddPlayerInteractor addPlayerInteractor;
    InMemoryPlayerDataAccessObject playerDAO;
    InMemoryScoreboardScoreboardDataAccessObject scoreboardDAO;
    InMemoryGameStateDataAccessObject gameStateDAO;
    ScoreboardViewModel scoreboardViewModel;
    @Before
    public void setUp() {
        this.playerDAO = new InMemoryPlayerDataAccessObject();
        this.scoreboardDAO = new InMemoryScoreboardScoreboardDataAccessObject();
        this.gameStateDAO = new InMemoryGameStateDataAccessObject();
        this.scoreboardViewModel = new ScoreboardViewModel();
        this.addPlayerInteractor = new AddPlayerInteractor(gameStateDAO, scoreboardDAO, playerDAO, scoreboardViewModel);
    }

    @Test
    public void execute() {
        AddPlayerInputData addPlayerInputData = new AddPlayerInputData("Ralph Lauren");

        addPlayerInteractor.execute(addPlayerInputData);
        assertEquals("Ralph Lauren", this.playerDAO.getPlayerList().get(0).getName());
        assertEquals(0, (int) this.scoreboardDAO.getScoreboard().getPlayerScore(this.playerDAO.getPlayerList().get(0)));
        assertTrue(this.scoreboardViewModel.getState().getScoreboard().containsKey(this.playerDAO.getPlayerList().get(0).getName()));
    }
}