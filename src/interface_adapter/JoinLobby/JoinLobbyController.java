package interface_adapter.JoinLobby;

import use_case.JoinLobby.JoinLobbyInputBoundary;
import use_case.JoinLobby.JoinLobbyInputData;

public class JoinLobbyController {
    final JoinLobbyInputBoundary joinLobbyInteractor;

    public JoinLobbyController(JoinLobbyInputBoundary joinLobbyInteractor) {
        this.joinLobbyInteractor = joinLobbyInteractor;
    }

    public void execute(String lobbyID) {
        JoinLobbyInputData inputData = new JoinLobbyInputData(lobbyID);
        joinLobbyInteractor.execute(inputData);
    }
}
