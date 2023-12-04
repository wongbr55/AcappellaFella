package use_case.RunGame;

import data_access.InMemoryGameStateDataAccessObject;
import data_access.InMemoryPlayerDataAccessObject;
import data_access.InMemoryRoundStateDataAccessObject;
import entity.Player;
import org.junit.Before;
import org.junit.Test;
import use_case.SendMessage.SendMessageInputBoundary;
import use_case.SendMessage.SendMessageInputData;

import static org.junit.Assert.*;

public class RunGameInteractorTest {

    private RunGameInteractor runGameInteractor;
    @Before
    public void setUp() throws Exception {
        InMemoryGameStateDataAccessObject gameStateDAO = new InMemoryGameStateDataAccessObject();
        InMemoryRoundStateDataAccessObject roundStateDAO = new InMemoryRoundStateDataAccessObject();
        InMemoryPlayerDataAccessObject playerDAO = new InMemoryPlayerDataAccessObject();

        RunGameOutputBoundary runGameOutputBoundary = new RunGameOutputBoundary() {
            @Override
            public void prepareSingerChooseView(RunGameSingerChooseOutputData runGameSingerChooseOutputData) {

            }

            @Override
            public void prepareSingerSingView(RunGameSingerSingOutputData runGameSingerSingOutputData) {

            }

            @Override
            public void prepareGuessView(RunGameGuessOutputData runGameGuessOutputData) {

            }

            @Override
            public void updateSingerChooseTimer(RunGameUpdateTimerOutputData runGameUpdateTimerOutputData) {

            }

            @Override
            public void updateSingerSingTimer(RunGameUpdateTimerOutputData runGameUpdateTimerOutputData) {

            }

            @Override
            public void updateGuessTimer(RunGameUpdateTimerOutputData runGameUpdateTimerOutputData) {

            }
        };

        SendMessageInputBoundary sendMessageInputBoundary = new SendMessageInputBoundary() {
            @Override
            public void execute(SendMessageInputData sendMessageInputData) {

            }
        };
        Player player = new Player();

        playerDAO.save(player);

        gameStateDAO.addPlayer(player);
        gameStateDAO.getGameState().setMainPlayer(player);

        runGameInteractor = new RunGameInteractor(gameStateDAO, roundStateDAO, playerDAO, runGameOutputBoundary, sendMessageInputBoundary);
    }

    @Test
    public void execute() {

        RunGameInputData runGameInputData = new RunGameInputData(1, 1);
        runGameInteractor.execute(runGameInputData);

    }
}