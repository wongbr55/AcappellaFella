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

        RunGamePlayerDataAccessInterface runGamePlayerDataAccessInterface = new RunGamePlayerDataAccessInterface() {
            @Override
            public List<Player> getPlayerList() {

                ArrayList<Player> players = new ArrayList<Player>();
                players.add(new Player());

                return players;
            }
        };

        gameStateDAO.addPlayer(player);
        gameStateDAO.getGameState().setMainPlayer(player);

        scoreboardDAO.addPlayer(player);

        RunGamePlaylistDataAccessInterface runGamePlaylistDataAccessInterface = new RunGamePlaylistDataAccessInterface() {
            @Override
            public List<Song> getThreeSongs() {
                ArrayList<Song> songs = new ArrayList<>();
                songs.add(new Song("Charlie Puth", "Attention"));
                songs.add(new Song("Charlie Puth", "Attention"));
                songs.add(new Song("Charlie Puth", "Attention"));

                return songs;
            }
        };

        runGameInteractor = new RunGameInteractor(gameStateDAO, roundStateDAO, runGamePlayerDataAccessInterface, runGamePlaylistDataAccessInterface, runGameOutputBoundary, sendMessageInputBoundary, scoreboardDAO);
    }

    @Test
    public void execute() {

        RunGameInputData runGameInputData = new RunGameInputData(1, 1);
        runGameInteractor.execute(runGameInputData);

    }
}