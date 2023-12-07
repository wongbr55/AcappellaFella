package data_access;

import entity.Song;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InMemoryRoundStateDataAccessObjectTest {

    InMemoryRoundStateDataAccessObject inMemoryRoundStateDataAccessObject;
    @Before
    public void setUp() {
        inMemoryRoundStateDataAccessObject = new InMemoryRoundStateDataAccessObject();
        inMemoryRoundStateDataAccessObject.addRound();
        Song song = new Song("Queen", "Don't stop me now");
        inMemoryRoundStateDataAccessObject.getCurrentRoundState().setSong(song);
    }

    @Test
    public void getCurrentRoundState() {
        assertEquals("Don't stop me now by Queen", this.inMemoryRoundStateDataAccessObject.getCurrentRoundState().getSong().toString());
    }

    @Test
    public void addRound() {
        this.inMemoryRoundStateDataAccessObject.addRound();
        Song newSong = new Song("Queen", "Bohemian Rhapsody");
        this.inMemoryRoundStateDataAccessObject.getCurrentRoundState().setSong(newSong);
        assertEquals("Bohemian Rhapsody by Queen", this.inMemoryRoundStateDataAccessObject.getCurrentRoundState().getSong().toString());
    }
}