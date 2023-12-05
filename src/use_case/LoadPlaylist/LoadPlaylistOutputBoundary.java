package use_case.LoadPlaylist;

public interface LoadPlaylistOutputBoundary {
    void prepareSuccessView(LoadPlaylistOutputData loadPlaylistOutputData);
    void prepareFailView(String error);
}
