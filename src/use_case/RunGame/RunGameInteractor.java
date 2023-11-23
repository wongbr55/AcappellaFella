package use_case.RunGame;

import entity.GameState;
import entity.Player;
import entity.RoundState;
import entity.Song;
import interface_adapter.SingerChoose.SingerChooseState;

import java.util.List;

public class RunGameInteractor implements RunGameInputBoundary {
    private final RunGameGameStateDataAccessInterface runGameGameStateDataAccessInterface;
    private final RunGameRoundStateDataAccessInterface runGameRoundStateDataAccessInterface;
    private final RunGamePlayerDataAccessInterface runGamePlayerDataAccessInterface;
    private final RunGameOutputBoundary runGamePresenter;

    public RunGameInteractor(RunGameGameStateDataAccessInterface runGameGameStateDataAccessInterface, RunGameRoundStateDataAccessInterface runGameRoundStateDataAccessInterface, RunGamePlayerDataAccessInterface runGamePlayerDataAccessInterface, RunGameOutputBoundary runGamePresenter) {
        this.runGameGameStateDataAccessInterface = runGameGameStateDataAccessInterface;
        this.runGameRoundStateDataAccessInterface = runGameRoundStateDataAccessInterface;
        this.runGamePlayerDataAccessInterface = runGamePlayerDataAccessInterface;
        this.runGamePresenter = runGamePresenter;
    }

    @Override
    public void execute(RunGameInputData runGameInputData) {
        List<Player> playerList = runGamePlayerDataAccessInterface.getPlayerList();
        GameState gameState = runGameGameStateDataAccessInterface.getGameState();

        // iterate over the number of rounds
        // NOTE: round has a different meaning here. A round here is where every player gets to sing once, i.e., for a
        // game with n players, there are n subRounds and each subRound has a corresponding RoundState
        // todo possibly change the naming convention to better reflect this
        for (int i = 0; i < runGameInputData.numberOfRounds; i++) {
            // each round, every player gets to sing once.
            for (Player singer : playerList) {
                // check if you are the singer
                if (singer.equals(gameState.getMainPlayer())) {
                    // basically how this works is that roundState has an attribute called singerState, which is either
                    //    - CHOOSING: it means the singer is choosing in the SingerChooseView, or
                    //    - SINGING: it means the singer is singing
                    //    - DONE: singer has finished singing, either because everyone guessed or time is up
                    // the singerChoose use case will update the state from CHOOSING to SINGING if everyone has finished singing
                    // the playerGuess use case will update the state from SINGING to DONE if everyone has guessed
                    // this use case will update the respective use case if a certain amount of time elapses

                    // create a new round
                    runGameRoundStateDataAccessInterface.addRound();
                    RoundState roundState = runGameRoundStateDataAccessInterface.getCurrentRoundState();

                    // PART 1: singer choose
                    // randomly choose 3 songs from somewhere
                    // todo below are placeholder songs, but we need someway to choose
                    SingerChooseState singerChooseState = new SingerChooseState();
                    Song song1 = new Song("Queen", "Don't Stop Me now");
                    Song song2 = new Song("Queen", "Bohemian Rhapsody");
                    Song song3 = new Song("Queen", "Another One Bites The Dust");
                    singerChooseState.setSong1(song1);
                    singerChooseState.setSong2(song2);
                    singerChooseState.setSong3(song3);

                    // update the view
                    runGamePresenter.prepareSingerChooseView(new RunGameSingerChooseOutputData(singerChooseState));

                    long startTime = System.currentTimeMillis();
                    long timeLimit = 10 * 1000; // 10 seconds to choose

                    while (roundState.getSingerState() == RoundState.SingerState.CHOOSING && (System.currentTimeMillis() - startTime) < timeLimit) {
                        // just wait and do nothing
                    }

                    // update the singerState
                    roundState.setSingerState(RoundState.SingerState.SINGING);

                    // todo need to send a system message out so that other players know to update their singing status

                    // PART 2: singer sing
                    runGamePresenter.prepareSingerSingView(new RunGameSingerSingOutputData());
                    startTime = System.currentTimeMillis();
                    timeLimit = runGameInputData.roundLength * 1000;

                    while (roundState.getSingerState() == RoundState.SingerState.SINGING && (System.currentTimeMillis() - startTime) < timeLimit) {
                        // just wait and do nothing
                    }

                    // update the singerState
                    roundState.setSingerState(RoundState.SingerState.DONE);
                }
                // otherwise, you're a guesser
                else {
                    runGamePresenter.prepareGuessView(new RunGameGuessOutputData());
                }
            }
        }
    }
}
