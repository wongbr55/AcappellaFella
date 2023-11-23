package use_case.RunGame;

import entity.*;
import interface_adapter.SingerChoose.SingerChooseState;
import use_case.SendMessage.SendMessageInputBoundary;
import use_case.SendMessage.SendMessageInputData;

import java.util.List;
import java.util.Random;

public class RunGameInteractor implements RunGameInputBoundary {
    private final RunGameGameStateDataAccessInterface gameStateDataAccessObject;
    private final RunGameRoundStateDataAccessInterface roundStateDataAccessObject;
    private final RunGamePlayerDataAccessInterface playerDataAccessObject;
    private final RunGameOutputBoundary runGamePresenter;
    private final SendMessageInputBoundary sendMessageInputBoundary;

    public RunGameInteractor(RunGameGameStateDataAccessInterface runGameGameStateDataAccessInterface, RunGameRoundStateDataAccessInterface runGameRoundStateDataAccessInterface, RunGamePlayerDataAccessInterface runGamePlayerDataAccessInterface, RunGameOutputBoundary runGamePresenter, SendMessageInputBoundary sendMessageInputBoundary) {
        this.gameStateDataAccessObject = runGameGameStateDataAccessInterface;
        this.roundStateDataAccessObject = runGameRoundStateDataAccessInterface;
        this.playerDataAccessObject = runGamePlayerDataAccessInterface;
        this.runGamePresenter = runGamePresenter;
        this.sendMessageInputBoundary = sendMessageInputBoundary;
    }

    @Override
    public void execute(RunGameInputData runGameInputData) {
        List<Player> playerList = playerDataAccessObject.getPlayerList();
        GameState gameState = gameStateDataAccessObject.getGameState();

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
                    roundStateDataAccessObject.addRound();
                    RoundState roundState = roundStateDataAccessObject.getCurrentRoundState();

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

                    // if the singer hasn't chosen a song and the time is up, choose one randomly
                    if (roundState.getSingerState() == RoundState.SingerState.CHOOSING) {
                        Random random = new Random();
                        Song[] songs = {song1, song2, song3};
                        roundState.setSong(songs[random.nextInt(3)]);
                    }

                    // update the singerState
                    roundState.setSingerState(RoundState.SingerState.SINGING);

                    String content = gameState.getMainPlayer().getName() + " has chose a song! Start guessing!";

                    SendMessageInputData sendMessageInputData = new SendMessageInputData(content, null, Message.MessageType.SYSTEM);
                    this.sendMessageInputBoundary.execute(sendMessageInputData);

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
