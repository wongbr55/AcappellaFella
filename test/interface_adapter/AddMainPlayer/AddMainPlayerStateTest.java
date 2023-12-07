package interface_adapter.AddMainPlayer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddMainPlayerStateTest {

    private AddMainPlayerState addMainPlayerState;
    @Before
    public void setUp() {
        addMainPlayerState = new AddMainPlayerState();
    }

    @Test
    public void getPlayerName() {
        assertNull(addMainPlayerState.getPlayerName());
    }

    @Test
    public void setPlayerName() {
        addMainPlayerState.setPlayerName("me");
        assertEquals("me", addMainPlayerState.getPlayerName());
    }
}