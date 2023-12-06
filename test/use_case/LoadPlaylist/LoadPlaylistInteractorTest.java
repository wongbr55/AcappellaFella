package use_case.LoadPlaylist;

import data_access.PlaylistSpotifyAPIDataAccessObject;
import entity.Song;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoadPlaylistInteractorTest {

    private PlaylistSpotifyAPIDataAccessObject loadPlaylistDataAccessObject;

    private LoadPlaylistInteractor loadPlaylistInteractor;
    @Before
    public void init() {
        LoadPlaylistOutputBoundary loadPlaylistOutputBoundary = new LoadPlaylistOutputBoundary() {
            @Override
            public void prepareSuccessView(LoadPlaylistOutputData loadPlaylistOutputData) {

            }

            @Override
            public void prepareFailView(String error) {

            }
        };
        this.loadPlaylistDataAccessObject = new PlaylistSpotifyAPIDataAccessObject();
        this.loadPlaylistInteractor = new LoadPlaylistInteractor(this.loadPlaylistDataAccessObject, loadPlaylistOutputBoundary);
    }

    @Test
    public void execute() {
        // make sure to add the proper client secret and id to the env variables of this test
        LoadPlaylistInputData loadPlaylistInputData = new LoadPlaylistInputData("hello", "hehe");

        loadPlaylistInteractor.execute(loadPlaylistInputData);

        LoadPlaylistInputData loadPlaylistInputData1 = new LoadPlaylistInputData("hello", null);

        loadPlaylistInteractor.execute(loadPlaylistInputData1);
    }
}