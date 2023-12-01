package app;

import interface_adapter.Home.HomeViewModel;
import interface_adapter.StartLobby.StartLobbyController;
import interface_adapter.StartLobby.StartLobbyLoggerModel;
import interface_adapter.StartLobby.StartLobbyPresenter;
import use_case.StartLobby.StartLobbyInputBoundary;
import use_case.StartLobby.StartLobbyInteractor;
import use_case.StartLobby.StartLobbyOutputBoundary;
import view.HomeView;

public class HomeUseCaseFactory {
    private HomeUseCaseFactory(){}

    public static HomeView create(HomeViewModel homeViewModel, StartLobbyLoggerModel startLobbyLoggerModel) {
        StartLobbyController startLobbyController = createStartLobbyUseCase(startLobbyLoggerModel);
        return new HomeView(homeViewModel, startLobbyController);
    }
    private static StartLobbyController createStartLobbyUseCase(StartLobbyLoggerModel startLobbyLoggerModel) {
        StartLobbyOutputBoundary startLobbyPresenter = new StartLobbyPresenter(startLobbyLoggerModel);
        StartLobbyInputBoundary startLobbyInteractor = new StartLobbyInteractor(startLobbyPresenter);

        return new StartLobbyController(startLobbyInteractor);
    }
}
