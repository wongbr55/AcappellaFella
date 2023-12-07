package interface_adapter.SingerChoose;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SingerChooseViewModelTest {

    SingerChooseViewModel singerChooseViewModel;
    @Before
    public void init() {
        singerChooseViewModel = new SingerChooseViewModel();
        singerChooseViewModel.getState().setSong1Name("Don't stop me now");
        singerChooseViewModel.getState().setSong2Name("Another one bites the dust");
        singerChooseViewModel.getState().setSong3Name("Bohemian Rhapsody");
        singerChooseViewModel.getState().setTime("0");
    }

    @Test
    public void testFirePropertyChanged() {
    }

    @Test
    public void testAddPropertyChangeListener() {
    }

    @Test
    public void testGetState() {
        assertEquals("Don't stop me now", this.singerChooseViewModel.getState().getSong1Name());
        assertEquals("Another one bites the dust", this.singerChooseViewModel.getState().getSong2Name());
        assertEquals("Bohemian Rhapsody", this.singerChooseViewModel.getState().getSong3Name());
        assertEquals("0", this.singerChooseViewModel.getState().getTime());
    }

    @Test
    public void testSetState() {
        SingerChooseState newSingerChooseState = new SingerChooseState();
        this.singerChooseViewModel.setState(newSingerChooseState);
        assertNull(this.singerChooseViewModel.getState().getSong1Name());
    }
}