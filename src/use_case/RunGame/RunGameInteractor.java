package use_case.RunGame;

import entity.Player;

import java.util.List;

public class RunGameInteractor implements RunGameInputBoundary {
    private final RunGameGameStateDataAccessInterface runGameGameStateDataAccessInterface;
    private final RunGameRoundStateDataAccessInterface runGameRoundStateDataAccessInterface;
    private final RunGamePlayerDataAccessInterface runGamePlayerDataAccessInterface;

    public RunGameInteractor(RunGameGameStateDataAccessInterface runGameGameStateDataAccessInterface, RunGameRoundStateDataAccessInterface runGameRoundStateDataAccessInterface, RunGamePlayerDataAccessInterface runGamePlayerDataAccessInterface) {
        this.runGameGameStateDataAccessInterface = runGameGameStateDataAccessInterface;
        this.runGameRoundStateDataAccessInterface = runGameRoundStateDataAccessInterface;
        this.runGamePlayerDataAccessInterface = runGamePlayerDataAccessInterface;
    }

    @Override
    public void execute(RunGameInputData runGameInputData) {
        List<Player> playerList = runGamePlayerDataAccessInterface.getPlayerList();

        // iterate over the number of rounds
        for (int i = 0; i < runGameInputData.numberOfRounds; i++) {
            // each round, every player gets to sing once
            for (Player player : playerList) {
                // the player gets to sing for runGameInputData.roundLength seconds, or until everyone has guessed
                long startTime = System.currentTimeMillis();
                long timeLimit = runGameInputData.roundLength * 1000; // 5 seconds in milliseconds
                boolean allGuessed = false;

                while (!allGuessed && (System.currentTimeMillis() - startTime) < timeLimit) {
                    // todo here!
                }
            }

        }
    }
}
