package interface_adapter.PlayerGuess;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerGuessViewModelTest {
    PlayerGuessViewModel playerGuessViewModel;
    @Before
    public void init() {
        playerGuessViewModel = new PlayerGuessViewModel();
        playerGuessViewModel.getState().setTime("0");
    }

    @Test
    public void testGetState() {
        assertEquals("Guess the Song!", this.playerGuessViewModel.getState().getTitleLabel());
    }

    @Test
    public void testSetState() {
        PlayerGuessState newPlayerGuessState = new PlayerGuessState();
        newPlayerGuessState.setTitleLabel("Start guessing!");
        this.playerGuessViewModel.setState(newPlayerGuessState);
        assertEquals("Start guessing!", this.playerGuessViewModel.getState().getTitleLabel());

    }

    @Test
    public void testFirePropertyChanged() {
    }

    @Test
    public void testAddPropertyChangeListener() {
    }
}