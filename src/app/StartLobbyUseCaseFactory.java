package app;

import interface_adapter.StartLobby.StartLobbyController;
import interface_adapter.StartLobby.StartLobbyViewModel;
import view.StartLobbyView;

public class StartLobbyUseCaseFactory {
    private StartLobbyUseCaseFactory(){}

    public static StartLobbyView create(StartLobbyViewModel startLobbyViewModel){
        StartLobbyController startLobbyController = createStartLobbyUseCase();
        return new StartLobbyView(startLobbyViewModel,startLobbyController);

    }

    private static StartLobbyController createStartLobbyUseCase() {
        return new StartLobbyController();
    }
}
