package interface_adapter.EndScreen;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndScreenViewModelTest {

    private EndScreenViewModel endScreenViewModel;
    @Before
    public void setUp() {
       endScreenViewModel = new EndScreenViewModel();
    }

    @Test
    public void getState() {
        endScreenViewModel.getState().setFirstPlace("Brandon", 12);
        EndScreenState endScreenState = endScreenViewModel.getState();

        assertEquals("Brandon", endScreenState.getFirstPlayerName());
        assertEquals(12, (int) endScreenState.getFirstScore());
    }
}