package interface_adapter.StartLobby;

import use_case.StartLobby.StartLobbyOutputBoundary;
import use_case.StartLobby.StartLobbyOutputData;

public class StartLobbyPresenter implements StartLobbyOutputBoundary {
    private final StartLobbyLoggerModel startLobbyLoggerModel;

    public StartLobbyPresenter(StartLobbyLoggerModel startLobbyLoggerModel) {
        this.startLobbyLoggerModel = startLobbyLoggerModel;
    }

    @Override
    public void createLobby(StartLobbyOutputData startLobbyOutputData) {
        StartLobbyState state = new StartLobbyState();
        startLobbyLoggerModel.setState(state);
        startLobbyLoggerModel.firePropertyChanged();
    }
}
