package use_case.AddMainPlayer;

import data_access.InMemoryGameStateDataAccessObject;
import data_access.InMemoryPlayerDataAccessObject;
import data_access.InMemoryScoreboardScoreboardDataAccessObject;
import interface_adapter.EnterWaitRoom.HostEnterWaitRoom.HostEnterWaitRoomController;
import interface_adapter.EnterWaitRoom.JoinEnterWaitRoom.JoinEnterWaitRoomController;
import interface_adapter.Scoreboard.ScoreboardViewModel;
import org.junit.Before;
import org.junit.Test;
import use_case.EnterChooseName.HostEnterChooseName.HostEnterChooseNameInputBoundary;
import use_case.EnterChooseName.HostEnterChooseName.HostEnterChooseNameInputData;
import use_case.EnterWaitRoom.HostEnterWaitRoom.HostEnterWaitRoomInputBoundary;
import use_case.EnterWaitRoom.HostEnterWaitRoom.HostEnterWaitRoomInputData;
import use_case.EnterWaitRoom.JoinEnterWaitRoom.JoinEnterWaitRoomInputBoundary;
import use_case.EnterWaitRoom.JoinEnterWaitRoom.JoinEnterWaitRoomInputData;
import use_case.SendMessage.SendMessageInputBoundary;
import use_case.SendMessage.SendMessageInputData;

import static org.junit.Assert.*;

public class AddMainPlayerInteractorTest {

    private AddMainPlayerInteractor addMainPlayerInteractor;
    private InMemoryGameStateDataAccessObject gameStateDAO;
    private InMemoryScoreboardScoreboardDataAccessObject scoreboardDAO;
    private InMemoryPlayerDataAccessObject playerDAO;
    @Before
    public void setUp() {
        scoreboardDAO = new InMemoryScoreboardScoreboardDataAccessObject();
        playerDAO = new InMemoryPlayerDataAccessObject();
        gameStateDAO = new InMemoryGameStateDataAccessObject();
        ScoreboardViewModel scoreboardViewModel1 = new ScoreboardViewModel();
        SendMessageInputBoundary sendMessageInputBoundary = new SendMessageInputBoundary() {
            @Override
            public void execute(SendMessageInputData sendMessageInputData) {

            }
        };
        JoinEnterWaitRoomInputBoundary joinEnterWaitRoomInputBoundary = new JoinEnterWaitRoomInputBoundary() {
            @Override
            public void execute(JoinEnterWaitRoomInputData joinEnterWaitRoomInputData) {

            }
        };
        JoinEnterWaitRoomController joinEnterWaitRoomController = new JoinEnterWaitRoomController(joinEnterWaitRoomInputBoundary);

        HostEnterWaitRoomInputBoundary hostEnterChooseNameInputBoundary = new HostEnterWaitRoomInputBoundary() {
            @Override
            public void execute(HostEnterWaitRoomInputData hostEnterWaitRoomInputData) {

            }
        };

        HostEnterWaitRoomController hostEnterWaitRoomController = new HostEnterWaitRoomController(hostEnterChooseNameInputBoundary);

        AddMainPlayerOutputBoundary addMainPlayerOutputBoundary = new AddMainPlayerOutputBoundary() {
            @Override
            public void updateChannel(AddMainPlayerOutputData addMainPlayerOutputData) {

            }
        };

        addMainPlayerInteractor = new AddMainPlayerInteractor(playerDAO, scoreboardDAO, gameStateDAO, scoreboardViewModel1, sendMessageInputBoundary, joinEnterWaitRoomController, hostEnterWaitRoomController, addMainPlayerOutputBoundary);
    }

    @Test
    public void execute() {

        AddMainPlayerInputData addMainPlayerInputData = new AddMainPlayerInputData("Brandon", "123", true);
        addMainPlayerInteractor.execute(addMainPlayerInputData);

        assertEquals("Brandon", gameStateDAO.getGameState().getMainPlayer().getName());
        assertEquals("Brandon", playerDAO.getPlayerList().get(0).getName());
        assertEquals(0, (int) scoreboardDAO.getScoreboard().getPlayerScore(gameStateDAO.getMainPlayer()));

        AddMainPlayerInputData addMainPlayerInputData1 = new AddMainPlayerInputData("Mark", "123", false);
        addMainPlayerInteractor.execute(addMainPlayerInputData1);

        assertEquals("Mark", gameStateDAO.getGameState().getMainPlayer().getName());
        assertEquals("Mark", playerDAO.getPlayerList().get(1).getName());
        assertEquals(0, (int) scoreboardDAO.getScoreboard().getPlayerScore(gameStateDAO.getMainPlayer()));

        AddMainPlayerInputData addMainPlayerInputData2 = new AddMainPlayerInputData("Mark", "123", false);
        addMainPlayerInteractor.execute(addMainPlayerInputData2);

        AddMainPlayerInputData addMainPlayerInputData3 = new AddMainPlayerInputData(null, "123", false);
        addMainPlayerInteractor.execute(addMainPlayerInputData3);

    }
}