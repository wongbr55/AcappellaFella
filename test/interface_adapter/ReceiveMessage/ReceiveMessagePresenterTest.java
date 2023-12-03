package interface_adapter.ReceiveMessage;

import entity.Message;
import entity.Player;
import interface_adapter.Chat.ChatViewModel;
import org.junit.Before;
import org.junit.Test;
import use_case.ReceiveMessage.ReceiveMessageOutputData;

import static org.junit.Assert.*;

public class ReceiveMessagePresenterTest {

    private ReceiveMessagePresenter receiveMessagePresenter;
    private ChatViewModel chatViewModel;
    @Before
    public void setUp() {
        chatViewModel = new ChatViewModel();
        receiveMessagePresenter = new ReceiveMessagePresenter(chatViewModel);
    }

    @Test
    public void prepareSuccessView() {

        Player author = new Player();
        author.setName("author");
        Message message = new Message(author, "Hello", Message.MessageType.ALL);
        ReceiveMessageOutputData receiveMessageOutputData = new ReceiveMessageOutputData(message, false);
        receiveMessagePresenter.prepareSuccessView(receiveMessageOutputData);

        ReceiveMessageOutputData receiveMessageOutputData1 = new ReceiveMessageOutputData(message, true);
        receiveMessagePresenter.prepareSuccessView(receiveMessageOutputData1);

        Message message1 = new Message(author, "Hello", Message.MessageType.SYSTEM);
        ReceiveMessageOutputData receiveMessageOutputData2 = new ReceiveMessageOutputData(message1, true);
        receiveMessagePresenter.prepareSuccessView(receiveMessageOutputData2);

        Message message3 = new Message(author, "Hello", Message.MessageType.GUESSED);
        ReceiveMessageOutputData receiveMessageOutputData3 = new ReceiveMessageOutputData(message3, true);
        receiveMessagePresenter.prepareSuccessView(receiveMessageOutputData3);


    }
}