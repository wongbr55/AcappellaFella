package use_case.ReceiveMessage;

import data_access.InMemoryGameStateDataAccessObject;
import data_access.InMemoryMessageHistoryDataAccessObject;
import data_access.InMemoryPlayerDataAccessObject;
import data_access.InMemoryRoundStateDataAccessObject;
import entity.Message;
import entity.MessageHistory;
import entity.Player;
import entity.Song;
import org.junit.Before;
import org.junit.Test;
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

        this.receiveMessageInteractor = new ReceiveMessageInteractor(gameStateDataAccessObject, roundStataDataAccessObject, messageHistoryDataAccessObject,
                playerDataAccessObject, receiveMessagePresenter, updateScoreInputBoundary);
    }

    @Test
    public void execute() {
        this.roundStataDataAccessObject.addRound();
        this.roundStataDataAccessObject.getCurrentRoundState().setSong(new Song("All Time Low", "Weightless"));

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

    }
}