package interface_adapter.Chat;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChatStateTest {

    ChatState chatState;

    @Before
    public void setUp() {
        chatState = new ChatState();
    }

    @Test
    public void getTypingContent() {
        assertEquals("", chatState.getTypingContent());
    }

    @Test
    public void setTypingContent() {
        chatState.setTypingContent("MAMA MIA");
        assertEquals("MAMA MIA", chatState.getTypingContent());
    }

    @Test
    public void getMessageHistory() {
        assertEquals("", chatState.getMessageHistory());
    }

    @Test
    public void setMessageHistory() {
        chatState.setMessageHistory("Hello");
        assertEquals("Hello", chatState.getMessageHistory());
    }
}