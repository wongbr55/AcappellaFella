package use_case.LoadPlaylist;

import entity.Playlist;

public class LoadPlaylistInteractor implements LoadPlaylistInputBoundary {

    private final LoadPlaylistDataAccessInterface loadPlaylistDataAccessObject;

    public LoadPlaylistInteractor(LoadPlaylistDataAccessInterface loadPlaylistDataAccessObject) {
        this.loadPlaylistDataAccessObject = loadPlaylistDataAccessObject;
    }


    @Override
    public Playlist execute() {
        Playlist playlist = loadPlaylistDataAccessObject.getPlaylist();
        return playlist;

    }
}
