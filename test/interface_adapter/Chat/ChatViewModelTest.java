package interface_adapter.Chat;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChatViewModelTest {

    ChatViewModel chatViewModel;
    @Before
    public void setUp() {
        chatViewModel = new ChatViewModel();
    }

    @Test
    public void getState() {
        ChatState chatState = chatViewModel.getState();
    }

    @Test
    public void setState() {
        ChatState chatState = new ChatState();
        chatViewModel.setState(chatState);

        assertEquals(chatState, chatViewModel.getState());
    }
}