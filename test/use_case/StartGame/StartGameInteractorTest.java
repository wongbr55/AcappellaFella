package use_case.StartGame;

import org.junit.Before;
import org.junit.Test;
import use_case.SendMessage.SendMessageInputBoundary;
import use_case.SendMessage.SendMessageInputData;

import static org.junit.Assert.*;

public class StartGameInteractorTest {

    private StartGameInteractor startGameInteractor;

    @Before
    public void init(){
        SendMessageInputBoundary sendMessageInputBoundary = new SendMessageInputBoundary() {
            @Override
            public void execute(SendMessageInputData sendMessageInputData) {

            }
        };

        startGameInteractor = new StartGameInteractor(sendMessageInputBoundary);
    }


    @Test
    public void execute() {

        StartGameInputData startGameInputData = new StartGameInputData(12, 2);
        startGameInteractor.execute(startGameInputData);

    }
}