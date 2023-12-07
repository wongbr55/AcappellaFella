package interface_adapter.StartGame;

import org.junit.Before;
import org.junit.Test;
import use_case.StartGame.StartGameInputBoundary;
import use_case.StartGame.StartGameInputData;

import static org.junit.Assert.*;

public class StartGameControllerTest {

    private StartGameController startGameController;
    @Before
    public void setUp() {
        StartGameInputBoundary startGameInputBoundary = new StartGameInputBoundary() {
            @Override
            public void execute(StartGameInputData startGameInputData) {

            }
        };

        startGameController = new StartGameController(startGameInputBoundary);
    }

    @Test
    public void execute() {
        startGameController.execute(1, 2, ".playlist/hehe\\?yeye");
    }
}