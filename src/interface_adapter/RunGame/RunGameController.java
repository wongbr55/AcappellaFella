package interface_adapter.RunGame;

import use_case.RunGame.RunGameInputBoundary;
import use_case.RunGame.RunGameInputData;

public class RunGameController {
    final RunGameInputBoundary runGameInteractor;

    public RunGameController(RunGameInputBoundary runGameInteractor) {
        this.runGameInteractor = runGameInteractor;
    }

    public void execute(int numberOfRounds, int roundLength) {
        RunGameInputData runGameInputData = new RunGameInputData(numberOfRounds, roundLength);
        runGameInteractor.execute(runGameInputData);
    }
}
