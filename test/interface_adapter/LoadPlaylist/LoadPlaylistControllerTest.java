package interface_adapter.LoadPlaylist;

import org.junit.Before;
import org.junit.Test;
import use_case.LoadPlaylist.LoadPlaylistInputBoundary;
import use_case.LoadPlaylist.LoadPlaylistInputData;
import use_case.LoadPlaylist.LoadPlaylistOutputBoundary;

import static org.junit.Assert.*;

public class LoadPlaylistControllerTest {

    private LoadPlaylistController loadPlaylistController;
    @Before
    public void setUp() {
        LoadPlaylistInputBoundary loadPlaylistInputBoundary = new LoadPlaylistInputBoundary() {
            @Override
            public void execute(LoadPlaylistInputData loadPlaylistInputData) {

            }
        };
        loadPlaylistController = new LoadPlaylistController(loadPlaylistInputBoundary);
    }

    @Test
    public void execute() {

        loadPlaylistController.execute(".playlist/hehe\\?hehe");
        loadPlaylistController.execute("Nah, Imma do my own thing ;)");

    }
}