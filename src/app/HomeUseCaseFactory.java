package app;

import interface_adapter.Home.HomeViewModel;
import interface_adapter.JoinLobby.JoinLobbyController;
import interface_adapter.JoinLobby.JoinLobbyLoggerModel;
import interface_adapter.JoinLobby.JoinLobbyPresenter;
import interface_adapter.StartLobby.StartLobbyController;
import interface_adapter.StartLobby.StartLobbyLoggerModel;
import interface_adapter.StartLobby.StartLobbyPresenter;
import use_case.JoinLobby.JoinLobbyInputBoundary;
import use_case.JoinLobby.JoinLobbyInteractor;
import use_case.JoinLobby.JoinLobbyOutputBoundary;
import use_case.StartLobby.StartLobbyInputBoundary;
import use_case.StartLobby.StartLobbyInteractor;
import use_case.StartLobby.StartLobbyOutputBoundary;
import view.HomeView;

public class HomeUseCaseFactory {
    private HomeUseCaseFactory(){}

    public static HomeView create(HomeViewModel homeViewModel, StartLobbyLoggerModel startLobbyLoggerModel, JoinLobbyLoggerModel joinLobbyLoggerModel) {
        StartLobbyController startLobbyController = createStartLobbyUseCase(startLobbyLoggerModel);
        JoinLobbyController joinLobbyController = createJoinLobbyUseCase(joinLobbyLoggerModel);
        return new HomeView(homeViewModel, startLobbyController, joinLobbyController);
    }
    private static StartLobbyController createStartLobbyUseCase(StartLobbyLoggerModel startLobbyLoggerModel) {
        StartLobbyOutputBoundary startLobbyPresenter = new StartLobbyPresenter(startLobbyLoggerModel);
        StartLobbyInputBoundary startLobbyInteractor = new StartLobbyInteractor(startLobbyPresenter);

        return new StartLobbyController(startLobbyInteractor);
    }

    private static JoinLobbyController createJoinLobbyUseCase(JoinLobbyLoggerModel joinLobbyLoggerModel) {
        JoinLobbyOutputBoundary joinLobbyOutputBoundary = new JoinLobbyPresenter(joinLobbyLoggerModel);
        JoinLobbyInputBoundary joinLobbyInputBoundary = new JoinLobbyInteractor(joinLobbyOutputBoundary);

        return new JoinLobbyController(joinLobbyInputBoundary);
    }
}
