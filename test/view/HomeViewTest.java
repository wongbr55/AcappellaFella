package view;

import interface_adapter.Home.HomeViewModel;
import interface_adapter.JoinLobby.JoinLobbyController;
import interface_adapter.StartLobby.StartLobbyController;
import org.junit.Before;
import org.junit.Test;
import use_case.JoinLobby.JoinLobbyInputBoundary;
import use_case.JoinLobby.JoinLobbyInputData;
import use_case.StartGame.StartGameInputBoundary;
import use_case.StartGame.StartGameInputData;
import use_case.StartLobby.StartLobbyInputBoundary;
import use_case.StartLobby.StartLobbyInputData;

import static org.junit.Assert.*;

public class HomeViewTest {
    HomeView homeView;
    HomeViewModel homeViewModel;
    StartLobbyController startLobbyController;
    StartLobbyInputBoundary startLobbyInputBoundary;
    JoinLobbyController joinLobbyController;
    JoinLobbyInputBoundary joinLobbyInputBoundary;

    @Test
    public void setUp() {
        homeViewModel = new HomeViewModel();
        startLobbyInputBoundary = new StartLobbyInputBoundary() {
            @Override
            public void execute(StartLobbyInputData startLobbyInputData) {

            }
        };
        startLobbyController = new StartLobbyController(startLobbyInputBoundary);
        joinLobbyInputBoundary = new JoinLobbyInputBoundary() {
            @Override
            public void execute(JoinLobbyInputData joinLobbyInputData) {

            }
        };
        joinLobbyController = new JoinLobbyController(joinLobbyInputBoundary);
        homeView = new HomeView(homeViewModel, startLobbyController, joinLobbyController);
    }

    @Test
    public void actionPerformed() {
    }

    @Test
    public void propertyChange() {
    }
}