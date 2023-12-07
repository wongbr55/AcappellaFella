package data_access;

import entity.Song;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PlaylistSpotifyAPIDataAccessObjectTest {

    PlaylistSpotifyAPIDataAccessObject playlistSpotifyAPIDataAccessObject;
    @Before
    public void setUp() {
        playlistSpotifyAPIDataAccessObject = new PlaylistSpotifyAPIDataAccessObject();
    }

    @Test
    public void loadPlaylist() {
        boolean getPlaylistSuccess = playlistSpotifyAPIDataAccessObject.loadPlaylist("37i9dQZF1DX5Ejj0EkURtP");
        assertTrue(getPlaylistSuccess);
    }

    @Test
    public void getThreeSongs() {
        playlistSpotifyAPIDataAccessObject.loadPlaylist("37i9dQZF1DX5Ejj0EkURtP");
        List<Song> threeSongs = playlistSpotifyAPIDataAccessObject.getThreeSongs();
        assertNotEquals(threeSongs.get(0).toString(), threeSongs.get(1).toString());
        assertNotEquals(threeSongs.get(0).toString(), threeSongs.get(2).toString());
        assertNotEquals(threeSongs.get(1).toString(), threeSongs.get(2).toString());
    }
}