package interface_adapter.SendMessage;

import entity.Message;
import entity.Player;
import org.junit.Before;
import org.junit.Test;
import use_case.SendMessage.SendMessageOutputData;

import static org.junit.Assert.*;

public class SendMessagePresenterTest {

    private SendMessagePresenter sendMessagePresenter;
    private SendMessageLoggerModel sendMessageLoggerModel;

    @Before
    public void setUp() {
        sendMessageLoggerModel = new SendMessageLoggerModel();
        sendMessagePresenter = new SendMessagePresenter(sendMessageLoggerModel);
    }

    @Test
    public void prepareSuccessView() {
        Player author = new Player();
        Message message = new Message(author, "hi", Message.MessageType.ALL);
        SendMessageOutputData sendMessageOutputData = new SendMessageOutputData(message);

        sendMessagePresenter.prepareSuccessView(sendMessageOutputData);
    }
}