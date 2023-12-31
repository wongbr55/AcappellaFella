package use_case.CheckGuess;

import data_access.InMemoryGameStateDataAccessObject;
import data_access.InMemoryRoundStateDataAccessObject;
import entity.Player;
import entity.RoundState;
import entity.Song;
import org.junit.Before;
import org.junit.Test;
import use_case.SendMessage.SendMessageInputBoundary;
import use_case.SendMessage.SendMessageInputData;

import static org.junit.Assert.*;

public class CheckGuessInteractorTest {

    private CheckGuessInteractor checkGuessInteractor;
    private InMemoryGameStateDataAccessObject gameStateDAO;
    private InMemoryRoundStateDataAccessObject roundStateDAO;

    @Before
    public void setUp() {
        gameStateDAO = new InMemoryGameStateDataAccessObject();
        roundStateDAO = new InMemoryRoundStateDataAccessObject();
        SendMessageInputBoundary sendMessageInputBoundary = new SendMessageInputBoundary() {
            @Override
            public void execute(SendMessageInputData sendMessageInputData) {

            }
        };

        checkGuessInteractor = new CheckGuessInteractor(gameStateDAO, roundStateDAO, sendMessageInputBoundary);
        roundStateDAO.addRound();
        roundStateDAO.getCurrentRoundState().setSong(new Song("Charlie Puth", "Attention"));

        Player player = new Player();
        player.setName("Brandon");

        gameStateDAO.getGameState().setMainPlayer(player);
    }

    @Test
    public void execute() {
        CheckGuessInputData incorrectGuess = new CheckGuessInputData("How long");
        checkGuessInteractor.execute(incorrectGuess);

        assertEquals(false, roundStateDAO.getCurrentRoundState().getGuessStatusByPlayer(gameStateDAO.getMainPlayer()));

        // set song and roundstatus to singing
        roundStateDAO.getCurrentRoundState().setSingerState(RoundState.SingerState.SINGING);
        roundStateDAO.getCurrentRoundState().setSong(new Song("Charlie Puth", "How Long"));

        CheckGuessInputData correctGuess = new CheckGuessInputData("ATTENTION");
        checkGuessInteractor.execute(correctGuess);

//        assertEquals(false, roundStateDAO.getCurrentRoundState().getGuessStatusByPlayer(gameStateDAO.getMainPlayer()));

        CheckGuessInputData guessGuess = new CheckGuessInputData("How long");
        checkGuessInteractor.execute(guessGuess);

        roundStateDAO.getCurrentRoundState().setGuessStatusByPlayer(gameStateDAO.getMainPlayer(), true);

        CheckGuessInputData guessedGuess = new CheckGuessInputData("How long");
        checkGuessInteractor.execute(guessedGuess);


    }
}