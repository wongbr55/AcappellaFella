package use_case.loadPlaylist;

public class LoadPlaylistInteractor implements LoadPlaylistInputBoundary {
    private final LoadPlaylistPlaylistDataAccessInterface loadPlaylistPlaylistDataAccessObject;
    private final LoadPlaylistOutputBoundary loadPlaylistPresenter;

    public LoadPlaylistInteractor(LoadPlaylistPlaylistDataAccessInterface loadPlaylistPlaylistDataAccessObject, LoadPlaylistOutputBoundary loadPlaylistPresenter) {
        this.loadPlaylistPlaylistDataAccessObject = loadPlaylistPlaylistDataAccessObject;
        this.loadPlaylistPresenter = loadPlaylistPresenter;
    }

    @Override
    public void execute(LoadPlaylistInputData loadPlaylistInputData) {
        if (loadPlaylistInputData.getPlaylistError() != null) {
            loadPlaylistPresenter.prepareFailView(loadPlaylistInputData.getPlaylistError());
            return;
        }

        boolean result = loadPlaylistPlaylistDataAccessObject.loadPlaylist(loadPlaylistInputData.getPlaylistID());
        if (result) {
            loadPlaylistPresenter.prepareSuccessView(new LoadPlaylistOutputData());
        } else {
            loadPlaylistPresenter.prepareFailView("Playlist id not found");
        }
    }
}
