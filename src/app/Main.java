package app;

import data_access.*;
import interface_adapter.AddMainPlayer.AddMainPlayerLoggerModel;
import interface_adapter.Chat.ChatViewModel;
import interface_adapter.ChooseName.HostChooseNameViewModel;
import interface_adapter.ChooseName.JoinChooseNameViewModel;
import interface_adapter.EndScreen.EndScreenViewModel;
import interface_adapter.Home.HomeViewModel;
import interface_adapter.JoinLobby.JoinLobbyLoggerModel;
import interface_adapter.PlayerGuess.PlayerGuessViewModel;
import interface_adapter.Scoreboard.ScoreboardViewModel;
import interface_adapter.SendMessage.SendMessageLoggerModel;
import interface_adapter.SingerChoose.SingerChooseViewModel;
import interface_adapter.SingerSing.SingerSingViewModel;
import interface_adapter.StartLobby.StartLobbyLoggerModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.WaitRoom.HostWaitRoomViewModel;
import interface_adapter.WaitRoom.JoinWaitRoomViewModel;
import logger.MessageLogger;
import use_case.UpdateScore.UpdateScoreInteractor;
import view.*;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("AcappellaFella");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // Message logger model
        SendMessageLoggerModel sendMessageLoggerModel = new SendMessageLoggerModel();
        StartLobbyLoggerModel startLobbyLoggerModel = new StartLobbyLoggerModel();
        JoinLobbyLoggerModel joinLobbyLoggerModel = new JoinLobbyLoggerModel();
        AddMainPlayerLoggerModel addMainPlayerLoggerModel = new AddMainPlayerLoggerModel();

        // View Models
        SingerChooseViewModel singerChooseViewModel = new SingerChooseViewModel();
        ChatViewModel chatViewModel = new ChatViewModel();
        SingerSingViewModel singerSingViewModel = new SingerSingViewModel();
        PlayerGuessViewModel playerGuessViewModel = new PlayerGuessViewModel();
        HomeViewModel homeViewModel = new HomeViewModel();
        JoinChooseNameViewModel joinChooseNameViewModel = new JoinChooseNameViewModel();
        HostChooseNameViewModel hostChooseNameViewModel = new HostChooseNameViewModel();
        JoinWaitRoomViewModel joinWaitRoomViewModel = new JoinWaitRoomViewModel();
        HostWaitRoomViewModel hostWaitRoomViewModel = new HostWaitRoomViewModel();
        ScoreboardViewModel scoreboardViewModel = new ScoreboardViewModel();
        EndScreenViewModel endScreenViewModel = new EndScreenViewModel();

        // DAOs
        InMemoryGameStateDataAccessObject gameStateDAO = new InMemoryGameStateDataAccessObject();
        InMemoryRoundStateDataAccessObject roundStateDAO = new InMemoryRoundStateDataAccessObject();
        InMemoryMessageHistoryDataAccessObject messageHistoryDAO = new InMemoryMessageHistoryDataAccessObject();
        InMemoryPlayerDataAccessObject playerDAO = new InMemoryPlayerDataAccessObject();
        InMemoryScoreboardScoreboardDataAccessObject scoreboardDAO = new InMemoryScoreboardScoreboardDataAccessObject();
        PlaylistSpotifyAPIDataAccessObject playlistDAO = new PlaylistSpotifyAPIDataAccessObject();

        // Lone controllers and interactors to be placed in other views/items/etc.
        UpdateScoreInteractor updateScoreInteractor = UpdateScoreUseCaseFactory.create(scoreboardDAO, roundStateDAO, scoreboardViewModel);

        // Message logger
        MessageLogger messageLogger = MessageLoggerUseCaseFactory.create(messageHistoryDAO, playerDAO, sendMessageLoggerModel, startLobbyLoggerModel, joinLobbyLoggerModel, addMainPlayerLoggerModel, playerGuessViewModel, singerChooseViewModel, singerSingViewModel, chatViewModel, homeViewModel, hostChooseNameViewModel, joinChooseNameViewModel, viewManagerModel, gameStateDAO, roundStateDAO, gameStateDAO, scoreboardDAO, playerDAO, gameStateDAO, roundStateDAO, playerDAO, gameStateDAO, playlistDAO, playlistDAO, scoreboardViewModel, updateScoreInteractor, endScreenViewModel, scoreboardDAO);

        // Views
        SingerChooseView singerChooseView = SingerChooseUseCaseFactory.create(viewManagerModel, singerChooseViewModel, roundStateDAO, singerSingViewModel);
        ScoreboardView scoreboardView = ScoreboardViewBuilder.createView(scoreboardViewModel);
        SingerSingView singerSingView = SingerSingUseCaseFactory.create(singerSingViewModel, scoreboardView);
        ChatView chatView = ChatUseCaseFactory.create(gameStateDAO, chatViewModel, sendMessageLoggerModel, playerGuessViewModel, gameStateDAO, roundStateDAO);
        EndScreenView endScreenView = EndScreenViewFactory.createView(endScreenViewModel);
        PlayerGuessView playerGuessView = PlayerGuessViewBuilder.createView(scoreboardView, chatView, playerGuessViewModel);
        HomeView homeView = HomeUseCaseFactory.create(homeViewModel, startLobbyLoggerModel, joinLobbyLoggerModel);
        JoinChooseNameView joinChooseNameView = ChooseNameViewFactory.createJoinView(hostWaitRoomViewModel, joinWaitRoomViewModel, hostChooseNameViewModel, joinChooseNameViewModel, scoreboardViewModel, viewManagerModel, addMainPlayerLoggerModel, sendMessageLoggerModel, playerDAO, scoreboardDAO, gameStateDAO, gameStateDAO);
        HostChooseNameView hostChooseNameView = ChooseNameViewFactory.createHostView(hostWaitRoomViewModel, joinWaitRoomViewModel, hostChooseNameViewModel, joinChooseNameViewModel, scoreboardViewModel, viewManagerModel, addMainPlayerLoggerModel, sendMessageLoggerModel, playerDAO, scoreboardDAO, gameStateDAO, gameStateDAO);
        JoinWaitRoomView joinWaitRoomView = JoinWaitRoomUseCaseFactory.create(joinWaitRoomViewModel);
        HostWaitRoomView hostWaitRoomView = HostWaitRoomUseCaseFactory.create(hostWaitRoomViewModel, sendMessageLoggerModel, gameStateDAO, playlistDAO);

        views.add(singerChooseView, singerChooseView.viewName);
        views.add(singerSingView, singerSingView.viewName);
        views.add(endScreenView, endScreenView.viewName);
        views.add(playerGuessView, playerGuessView.viewName);
        views.add(homeView, homeView.viewName);
        views.add(joinChooseNameView, joinChooseNameView.viewName);
        views.add(hostChooseNameView, hostChooseNameView.viewName);
        views.add(joinWaitRoomView, joinWaitRoomView.viewName);
        views.add(hostWaitRoomView, hostWaitRoomView.viewName);

        viewManagerModel.setActiveView(homeView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);

        // runGameController.execute(3, 10);
    }
}