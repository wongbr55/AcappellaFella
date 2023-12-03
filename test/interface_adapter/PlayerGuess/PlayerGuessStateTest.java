package interface_adapter.PlayerGuess;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerGuessStateTest {
    PlayerGuessState playerGuessState;
    @Before
    public void init() {
        playerGuessState = new PlayerGuessState();
        playerGuessState.setTime("0");
    }

    @Test
    public void testGetTitleLabel() {
        assertEquals("Guess the Song!", this.playerGuessState.getTitleLabel());
    }

    @Test
    public void testSetTitleLabel() {
        this.playerGuessState.setTitleLabel("Start guessing!");
        assertEquals("Start guessing!", this.playerGuessState.getTitleLabel());
    }

    @Test
    public void testGetTime() {
        assertEquals("0", this.playerGuessState.getTime());
    }

    @Test
    public void testSetTime() {
        this.playerGuessState.setTime("10");
        assertEquals("10", this.playerGuessState.getTime());
    }
}