package entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlaylistTest {

    private Playlist playlist;
    private Song songA;
    private Song songB;
    private Song songC;
    @Before
    public void init() {
        playlist = new Playlist();
        songA = new Song("A", "Alalala");
        songB = new Song("B", "Bababab");
        songC = new Song("C", "Cacacac");

        playlist.setSongOne(songA);
        playlist.setSongTwo(songB);
        playlist.setSongThree(songC);
    }

    @Test
    public void testGetSongOne() {
        assertEquals("Alalala by A", playlist.getSongOne().toString());
    }

    @Test
    public void testSetSongOne() {
        playlist.setSongOne(songB);
        assertEquals("Bababab by B", playlist.getSongOne().toString());
    }

    @Test
    public void testGetSongTwo() {
        assertEquals("Bababab by B", playlist.getSongTwo().toString());
    }

    @Test
    public void testSetSongTwo() {
        playlist.setSongTwo(songC);
        assertEquals("Cacacac by C", playlist.getSongTwo().toString());
    }

    @Test
    public void testGetSongThree() {
        assertEquals("Cacacac by C", playlist.getSongThree().toString());
    }

    @Test
    public void testSetSongThree() {
        playlist.setSongThree(songA);
        assertEquals("Alalala by A", playlist.getSongThree().toString());
    }
}