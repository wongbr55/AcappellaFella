package app;

import interface_adapter.JoinLobby.JoinLobbyController;
import interface_adapter.JoinLobby.JoinLobbyViewModel;

public class JoinLobbyUseCaseFactory {
    private JoinLobbyUseCaseFactory(){}

    public static JoinLobbyView create(JoinLobbyViewModel joinLobbyViewModel){
        JoinLobbyController joinLobbyController = createJoinLobbyUseCase();
        return new JoinLobbyView(joinLobbyViewModel,joinLobbyController);

    }

    private static JoinLobbyController createJoinLobbyUseCase() {
        return new JoinLobbyController();
    }
}
