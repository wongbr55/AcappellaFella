package interface_adapter.StartLobby;

import use_case.StartLobby.StartLobbyOutputBoundary;
import use_case.StartLobby.StartLobbyOutputData;

public class StartLobbyPresenter implements StartLobbyOutputBoundary {
    private final StartLobbyLoggerModel startLobbyLoggerModel;

    public StartLobbyPresenter(StartLobbyLoggerModel startLobbyLoggerModel) {
        this.startLobbyLoggerModel = startLobbyLoggerModel;
    }

    @Override
    public void prepareSuccessView(StartLobbyOutputData startLobbyOutputData) {

    }

    @Override
    public void prepareFailView(String error) {

    }

    @Override
    public void createLobby() {
        StartLobbyState state = new StartLobbyState();
        startLobbyLoggerModel.setState(state);
        startLobbyLoggerModel.firePropertyChanged();
    }
}
