package use_case.loadPlaylist;

public interface LoadPlaylistOutputBoundary {
    void prepareSuccessView(LoadPlaylistOutputData loadPlaylistOutputData);
    void prepareFailView(String error);
}
