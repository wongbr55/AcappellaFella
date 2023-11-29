package use_case.StartLobby;

public interface StartLobbyOutputBoundary {
    void prepareSuccessView(StartLobbyOutputData startLobbyOutputData);

    void prepareFailView(String error);
}
