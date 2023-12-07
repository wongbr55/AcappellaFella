package use_case.RunGame;

import data_access.*;
import entity.Player;
import entity.Song;
import org.junit.Before;
import org.junit.Test;
import use_case.SendMessage.SendMessageInputBoundary;
import use_case.SendMessage.SendMessageInputData;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RunGameInteractorTest {

    private RunGameInteractor runGameInteractor;
    @Before
    public void setUp() throws Exception {
        InMemoryGameStateDataAccessObject gameStateDAO = new InMemoryGameStateDataAccessObject();
        InMemoryRoundStateDataAccessObject roundStateDAO = new InMemoryRoundStateDataAccessObject();
        InMemoryPlayerDataAccessObject playerDAO = new InMemoryPlayerDataAccessObject();
        InMemoryScoreboardScoreboardDataAccessObject scoreboardDAO = new InMemoryScoreboardScoreboardDataAccessObject();


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

            @Override
            public void prepareEndView(RunGameEndScreenOutputData runGameEndScreenOutputData) {

            }
        };

        SendMessageInputBoundary sendMessageInputBoundary = new SendMessageInputBoundary() {
            @Override
            public void execute(SendMessageInputData sendMessageInputData) {

            }
        };
        Player player = new Player();

        gameStateDAO.addPlayer(player);
        gameStateDAO.getGameState().setMainPlayer(player);

        scoreboardDAO.addPlayer(player);

        playerDAO.save(player);

        RunGamePlaylistDataAccessInterface runGamePlaylistDataAccessInterface = new RunGamePlaylistDataAccessInterface() {
            @Override
            public List<Song> getThreeSongs() {
                ArrayList<Song> songs = new ArrayList<>();
                songs.add(new Song("Charlie Puth", "Attention"));
                songs.add(new Song("Harry Styles", "Watermelon Sugar"));
                songs.add(new Song("Maroon 5", "Maps"));

                return songs;
            }
        };

        runGameInteractor = new RunGameInteractor(gameStateDAO, roundStateDAO, playerDAO, runGamePlaylistDataAccessInterface, runGameOutputBoundary, sendMessageInputBoundary, scoreboardDAO);
    }

    @Test
    public void execute() {

        RunGameInputData runGameInputData = new RunGameInputData(1, 1);
        runGameInteractor.execute(runGameInputData);

    }
}