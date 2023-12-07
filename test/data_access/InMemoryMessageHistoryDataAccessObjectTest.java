package data_access;

import entity.Message;
import entity.MessageHistory;
import entity.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InMemoryMessageHistoryDataAccessObjectTest {

    private InMemoryMessageHistoryDataAccessObject messageDAO;
    @Before
    public void setUp() {
        messageDAO = new InMemoryMessageHistoryDataAccessObject();
    }

    @Test
    public void getMessageHistory() {
        Player author = new Player();
        messageDAO.getMessageHistory().addMessage(new Message(author, "yolo", Message.MessageType.ALL));
        MessageHistory messageHistory = messageDAO.getMessageHistory();
    }
}