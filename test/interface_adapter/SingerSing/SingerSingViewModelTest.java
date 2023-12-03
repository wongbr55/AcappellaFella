package interface_adapter.SingerSing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SingerSingViewModelTest {

    SingerSingViewModel singerSingViewModel;

    @Before
    public void init() {
        singerSingViewModel = new SingerSingViewModel();
        singerSingViewModel.getState().setSongLabel("Don't stop me now by Queens");
    }

    @Test
    public void testGetState() {
        assertEquals("Don't stop me now by Queens", this.singerSingViewModel.getState().getSongLabel());

    }

    @Test
    public void testFirePropertyChanged() {
    }

    @Test
    public void testAddPropertyChangeListener() {
    }

    @Test
    public void getTitleLabel() {
        assertEquals("Start Singing!", this.singerSingViewModel.getTitleLabel());
    }
}