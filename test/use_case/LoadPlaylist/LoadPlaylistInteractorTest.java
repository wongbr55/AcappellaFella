package use_case.LoadPlaylist;

import data_access.APIDataAccessObject;
import entity.Playlist;
import entity.Song;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoadPlaylistInteractorTest {

    private APIDataAccessObject loadPlaylistDataAccessObject;

    private LoadPlaylistInteractor loadPlaylistInteractor;
    @Before
    public void init() {
        this.loadPlaylistDataAccessObject = new APIDataAccessObject();
        this.loadPlaylistInteractor = new LoadPlaylistInteractor(this.loadPlaylistDataAccessObject);
    }

    @Test
    public void execute() {
        // make sure to add the proper client secret and id to the env variables of this test
        Playlist playlist = loadPlaylistInteractor.execute();
        String songOne = playlist.getSongOne().toString();
        String songTwo = playlist.getSongTwo().toString();
        String songThree = playlist.getSongThree().toString();
        assertTrue(!songOne.equals(songTwo) && !songOne.equals(songThree) && !songTwo.equals(songThree));
    }
}