package use_case.SendMessage;

import data_access.InMemoryGameStateDataAccessObject;
import entity.Message;
import entity.Player;
import org.junit.Before;
import org.junit.Test;

public class SendMessageInteractorTest {

    private SendMessageInteractor sendMessageInteractor;
    @Before
    public void init(){
        SendMessageOutputBoundary sendMessageOutputBoundary = new SendMessageOutputBoundary() {
            @Override
            public void prepareSuccessView(SendMessageOutputData sendMessageOutputData) {

            }

            @Override
            public void prepareFailView(String error) {

            }
        };

        InMemoryGameStateDataAccessObject gameStateDataAccessObject = new InMemoryGameStateDataAccessObject();

        sendMessageInteractor = new SendMessageInteractor(gameStateDataAccessObject, sendMessageOutputBoundary);

    }

    @Test
    public void execute() {
        Player author = new Player();
        author.setName("author");
        SendMessageInputData sendMessageInputData = new SendMessageInputData("hello", author);
        sendMessageInteractor.execute(sendMessageInputData);

        SendMessageInputData sendMessageInputData1 = new SendMessageInputData("bye", author, Message.MessageType.SYSTEM);

        sendMessageInteractor.execute(sendMessageInputData1);
    }
}