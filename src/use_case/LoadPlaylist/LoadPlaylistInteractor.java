package use_case.LoadPlaylist;

import entity.Playlist;

public class LoadPlaylistInteractor implements LoadPlaylistInputBoundary {

    private final LoadPlaylistDataAccessInterface loadPlaylistDataAccessObject;
    private final LoadPlaylistOutputBoundary loadPlaylistPresenter;

    public LoadPlaylistInteractor(LoadPlaylistDataAccessInterface loadPlaylistDataAccessObject, LoadPlaylistOutputBoundary loadPlaylistPresenter) {
        this.loadPlaylistDataAccessObject = loadPlaylistDataAccessObject;
        this.loadPlaylistPresenter = loadPlaylistPresenter;
    }


    @Override
    public void execute() {
        Playlist playlist = loadPlaylistDataAccessObject.getPlaylist();

    }
}
