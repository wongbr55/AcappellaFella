package interface_adapter.StartLobby;

import view.StartLobbyView;

public class StartLobbyViewModel {

    public static final String START_BUTTON_LABEL = "Start Lobby";

    public static StartLobbyState getState() {
        return null;
    }

    public void addPropertyChangeListener(StartLobbyView startLobbyView) {
    }

    public void setState(StartLobbyState currentState) {
    }
}
