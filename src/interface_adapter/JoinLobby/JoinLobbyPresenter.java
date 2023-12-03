package interface_adapter.JoinLobby;

import use_case.JoinLobby.JoinLobbyOutputBoundary;
import use_case.JoinLobby.JoinLobbyOutputData;

public class JoinLobbyPresenter implements JoinLobbyOutputBoundary {
    private final JoinLobbyLoggerModel joinLobbyLoggerModel;

    public JoinLobbyPresenter(JoinLobbyLoggerModel joinLobbyLoggerModel) {
        this.joinLobbyLoggerModel = joinLobbyLoggerModel;
    }

    @Override
    public void prepareSuccessView(JoinLobbyOutputData joinLobbyOutputData) {
        joinLobbyLoggerModel.getState().setLobbyID(joinLobbyOutputData.getLobbyID());
        joinLobbyLoggerModel.firePropertyChanged();
    }
}
