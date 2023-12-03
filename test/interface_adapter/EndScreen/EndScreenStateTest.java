package interface_adapter.EndScreen;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndScreenStateTest {

    private EndScreenState endScreenState;
    @Before
    public void setUp() {
        endScreenState = new EndScreenState();
    }

    @Test
    public void setFirstPlace() {
        endScreenState.setFirstPlace("Brandon", 12);
    }

    @Test
    public void getFirstScore() {
        endScreenState.setFirstPlace("Brandon", 12);
        assertEquals("Brandon", endScreenState.getFirstPlayerName());
        assertEquals(12, (int) endScreenState.getFirstScore());
    }

    @Test
    public void getFirstPlayerName() {
        endScreenState.setFirstPlace("Brandon", 12);
        assertEquals(12, (int) endScreenState.getFirstScore());
    }
}