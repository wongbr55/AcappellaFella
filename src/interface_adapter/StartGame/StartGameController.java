package interface_adapter.StartGame;

import use_case.StartGame.StartGameInputBoundary;
import use_case.StartGame.StartGameInputData;

public class StartGameController {
    private final StartGameInputBoundary startGameInteractor;

    public StartGameController(StartGameInputBoundary startGameInteractor) {
        this.startGameInteractor = startGameInteractor;
    }

    public void execute(int numberOfRounds, int roundLength) {
        StartGameInputData inputData = new StartGameInputData(numberOfRounds, roundLength);
        startGameInteractor.execute(inputData);
    }
}
