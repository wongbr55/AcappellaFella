package interface_adapter.SingerChoose;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SingerChooseStateTest {

    SingerChooseState singerChooseState;
    @Before
    public void init() {
        singerChooseState = new SingerChooseState();
        singerChooseState.setSong1Name("Don't stop me now");
        singerChooseState.setSong2Name("Another one bites the dust");
        singerChooseState.setSong3Name("Bohemian Rhapsody");
        singerChooseState.setTime("0");
    }

    @Test
    public void testGetSong1Name() {
        assertEquals("Don't stop me now", this.singerChooseState.getSong1Name());
    }

    @Test
    public void testSetSong1Name() {
        this.singerChooseState.setSong1Name("AAAA");
        assertEquals("AAAA", this.singerChooseState.getSong1Name());
    }

    @Test
    public void testGetSong2Name() {
        assertEquals("Another one bites the dust", this.singerChooseState.getSong2Name());
    }

    @Test
    public void testSetSong2Name() {
        this.singerChooseState.setSong2Name("BBBB");
        assertEquals("BBBB", this.singerChooseState.getSong2Name());
    }

    @Test
    public void testGetSong3Name() {
        assertEquals("Bohemian Rhapsody", this.singerChooseState.getSong3Name());
    }

    @Test
    public void testSetSong3Name() {
        this.singerChooseState.setSong3Name("CCCC");
        assertEquals("CCCC", this.singerChooseState.getSong3Name());
    }

    @Test
    public void testGetTime() {
        assertEquals("0", this.singerChooseState.getTime());
    }

    @Test
    public void testSetTime() {
        this.singerChooseState.setTime("10");
        assertEquals("10", this.singerChooseState.getTime());
    }
}