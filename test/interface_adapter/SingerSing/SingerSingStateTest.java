package interface_adapter.SingerSing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SingerSingStateTest {

    SingerSingState singerSingState;
    @Before
    public void init() {
        this.singerSingState = new SingerSingState();
        this.singerSingState.setSongLabel("Don't stop me now by Queens");
        this.singerSingState.setTime("0");
    }

    @Test
    public void testGetSongLabel() {
        assertEquals("Don't stop me now by Queens", this.singerSingState.getSongLabel());
    }

    @Test
    public void testSetSongLabel() {
        this.singerSingState.setSongLabel("Bohemian Rhapsody by Queens");
        assertEquals("Bohemian Rhapsody by Queens", this.singerSingState.getSongLabel());
    }

    @Test
    public void testGetTime() {
        assertEquals("0", this.singerSingState.getTime());
    }

    @Test
    public void testSetTime() {
        this.singerSingState.setTime("10");
        assertEquals("10", this.singerSingState.getTime());
    }
}