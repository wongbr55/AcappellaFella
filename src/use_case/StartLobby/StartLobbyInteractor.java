package use_case.StartLobby;

public class StartLobbyInteractor implements StartLobbyInputBoundary {
    final StartLobbyOutputBoundary startLobbyPresenter;

    public StartLobbyInteractor(StartLobbyOutputBoundary startLobbyPresenter) {
        this.startLobbyPresenter = startLobbyPresenter;
    }

    public void execute(StartLobbyInputData startLobbyInputData){
        // create lobby
        startLobbyPresenter.createLobby();
    }
}
