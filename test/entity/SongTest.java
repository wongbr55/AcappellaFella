package entity;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class SongTest {

    private Song song;

    @Before
    public void init() {
        song = new Song("Queen", "Another one bites the dust");
    }

    @Test
    public void testToString() {
        assertEquals("Another one bites the dust by Queen", song.toString());
    }

    @Test
    public void testGetTitle() {
        assertEquals("Another one bites the dust", song.getTitle());
    }

    @Test
    public void testSetTitle() {
        song.setTitle("Don't stop me now");
        assertEquals("Don't stop me now", song.getTitle());
    }

    @Test
    public void testGetArtist() {
        assertEquals("Queen", song.getArtist());
    }

    @Test
    public void testSetArtist() {
        song.setArtist("King");
        assertEquals("King", song.getArtist());
    }
}