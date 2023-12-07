package use_case.ReceiveMessage;

import data_access.*;
import entity.Message;
import entity.MessageHistory;
import entity.Player;
import entity.Song;
import interface_adapter.AddPlayer.AddPlayerController;
import interface_adapter.RunGame.RunGameController;
import org.junit.Before;
import org.junit.Test;
import use_case.AddPlayer.AddPlayerInputBoundary;
import use_case.AddPlayer.AddPlayerInputData;
import use_case.RunGame.RunGameInputBoundary;
import use_case.RunGame.RunGameInputData;
import use_case.UpdateScore.UpdateScoreInputBoundary;
import use_case.UpdateScore.UpdateScoreInputData;

import static org.junit.Assert.*;

public class ReceiveMessageInteractorTest {

    private ReceiveMessageInteractor receiveMessageInteractor;
    private ReceiveMessageGameStateDataAccessInterface gameStateDataAccessObject;

    private InMemoryRoundStateDataAccessObject roundStataDataAccessObject;
    private InMemoryMessageHistoryDataAccessObject messageHistoryDataAccessObject;
    private ReceiveMessagePlayerDataAccessInterface playerDataAccessObject;
    private ReceiveMessageOutputBoundary receiveMessagePresenter;

    private UpdateScoreInputBoundary updateScoreInputBoundary;
    @Before
    public void setUp() {
        roundStataDataAccessObject = new InMemoryRoundStateDataAccessObject();
        messageHistoryDataAccessObject = new InMemoryMessageHistoryDataAccessObject();
        playerDataAccessObject = new InMemoryPlayerDataAccessObject();
        gameStateDataAccessObject = new InMemoryGameStateDataAccessObject();
        updateScoreInputBoundary = new UpdateScoreInputBoundary() {
            @Override
            public void execute(UpdateScoreInputData updateScoreInputData) {

            }
        };
        receiveMessagePresenter = new ReceiveMessageOutputBoundary() {
            @Override
            public void prepareSuccessView(ReceiveMessageOutputData receiveMessageOutputData) {

            }

            @Override
            public void prepareFailView(String error) {

            }
        };
        AddPlayerInputBoundary addPlayerInputBoundary = new AddPlayerInputBoundary() {
            @Override
            public void execute(AddPlayerInputData addPlayerInputData) {

            }
        };
        AddPlayerController addPlayerController = new AddPlayerController(addPlayerInputBoundary);
        RunGameInputBoundary runGameInputBoundary = new RunGameInputBoundary() {
            @Override
            public void execute(RunGameInputData runGameInputData) {

            }
        };
        RunGameController runGameController = new RunGameController(runGameInputBoundary);

        PlaylistSpotifyAPIDataAccessObject playlistSpotifyAPIDataAccessObject = new PlaylistSpotifyAPIDataAccessObject();

        this.receiveMessageInteractor = new ReceiveMessageInteractor(gameStateDataAccessObject, roundStataDataAccessObject, messageHistoryDataAccessObject,
                playlistSpotifyAPIDataAccessObject, playerDataAccessObject, addPlayerController, runGameController, receiveMessagePresenter, updateScoreInputBoundary);
    }

    @Test
    public void execute() {
        this.roundStataDataAccessObject.addRound();
        this.roundStataDataAccessObject.getCurrentRoundState().setSong(new Song("All Time Low", "Weightless"));

        gameStateDataAccessObject.getGameState().setMainPlayer(new Player("Brandon"));

        ReceiveMessageInputData receiveMessageInputData1 = new ReceiveMessageInputData("Brandon", "Hello", "ALL");
        this.receiveMessageInteractor.execute(receiveMessageInputData1);

        Message message1 = messageHistoryDataAccessObject.getMessageHistory().getHistory().get(0);

        assertEquals("Hello", message1.getContent());
        assertEquals(Message.MessageType.ALL, message1.getType());
//        assertEquals("Brandon", message1.getAuthor().getName());

        ReceiveMessageInputData receiveMessageInputData2 = new ReceiveMessageInputData("", "Brandon has guessed the answer!", "SYSTEM");
        this.receiveMessageInteractor.execute(receiveMessageInputData2);

        Message message2 = messageHistoryDataAccessObject.getMessageHistory().getHistory().get(1);

        assertEquals("Brandon has guessed the answer!", message2.getContent());
        assertEquals(Message.MessageType.SYSTEM, message2.getType());

        ReceiveMessageInputData receiveMessageInputData3 = new ReceiveMessageInputData("", "yolo", "GUESSED");
        this.receiveMessageInteractor.execute(receiveMessageInputData3);

        Message message3 = messageHistoryDataAccessObject.getMessageHistory().getHistory().get(2);

        assertEquals("yolo", message3.getContent());
        assertEquals(Message.MessageType.GUESSED, message3.getType());

        ReceiveMessageInputData receiveMessageInputData4 = new ReceiveMessageInputData("", "mark has joined.", "SYSTEM");
        this.receiveMessageInteractor.execute(receiveMessageInputData4);

        ReceiveMessageInputData receiveMessageInputData5 = new ReceiveMessageInputData("", "Song: Hello by Adelle", "INVIS_SYSTEM");
        this.receiveMessageInteractor.execute(receiveMessageInputData5);

        ReceiveMessageInputData receiveMessageInputData6 = new ReceiveMessageInputData("", "ROUND DONE", "INVIS_SYSTEM");
        this.receiveMessageInteractor.execute(receiveMessageInputData6);

        ReceiveMessageInputData receiveMessageInputData7 = new ReceiveMessageInputData("", "GAME STARTED\n1\n1\n2", "INVIS_SYSTEM");
        this.receiveMessageInteractor.execute(receiveMessageInputData7);

    }
}