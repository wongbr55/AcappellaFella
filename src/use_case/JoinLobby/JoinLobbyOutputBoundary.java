package use_case.JoinLobby;

public interface JoinLobbyOutputBoundary {
    void prepareSuccessView(JoinLobbyOutputData joinLobbyOutputData);

    void prepareFailView(String error);
}
