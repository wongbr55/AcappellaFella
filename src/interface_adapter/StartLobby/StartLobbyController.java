package interface_adapter.StartLobby;

import use_case.StartLobby.StartLobbyInputBoundary;
import use_case.StartLobby.StartLobbyInputData;

public class StartLobbyController {
    final StartLobbyInputBoundary startLobbyInteractor;

    public StartLobbyController(StartLobbyInputBoundary startLobbyInteractor) {
        this.startLobbyInteractor = startLobbyInteractor;
    }

    public void execute() {
        StartLobbyInputData startLobbyInputData = new StartLobbyInputData();
        startLobbyInteractor.execute(startLobbyInputData);
    }
}
