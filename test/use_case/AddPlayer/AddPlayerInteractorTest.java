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
        Player player = new Player();
        player.setName("Ralph Lauren");
        AddPlayerInputData addPlayerInputData = new AddPlayerInputData(player.getName());

        addPlayerInteractor.execute(addPlayerInputData);
        assertTrue(this.playerDAO.getPlayerList().contains(player));
        assertEquals(0, (int) this.scoreboardDAO.getScoreboard().getPlayerScore(player));
        assertTrue(this.scoreboardViewModel.getState().getScoreboard().containsKey(player.getName()));
    }
}