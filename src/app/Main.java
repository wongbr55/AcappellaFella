package app;

import data_access.*;
import entity.Player;
import entity.Song;
import interface_adapter.AddPlayer.AddPlayerController;
import interface_adapter.Chat.ChatViewModel;
import interface_adapter.EndScreen.EndScreenViewModel;
import interface_adapter.PlayerGuess.PlayerGuessViewModel;
import interface_adapter.RunGame.RunGameController;
import interface_adapter.SendMessage.SendMessageLoggerModel;
import interface_adapter.SingerChoose.SingerChooseState;
import interface_adapter.SingerChoose.SingerChooseViewModel;
import interface_adapter.SingerSing.SingerSingViewModel;
import interface_adapter.Scoreboard.ScoreboardViewModel;
import interface_adapter.ViewManagerModel;
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
        JFrame application = new JFrame("brandon");
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

        // View Models
        SingerChooseViewModel singerChooseViewModel = new SingerChooseViewModel();
        ChatViewModel chatViewModel = new ChatViewModel();
        SingerSingViewModel singerSingViewModel = new SingerSingViewModel();
        PlayerGuessViewModel playerGuessViewModel = new PlayerGuessViewModel();
        ScoreboardViewModel scoreboardViewModel = new ScoreboardViewModel();
        EndScreenViewModel endScreenViewModel = new EndScreenViewModel();


        // DAOs
        InMemoryGameStateDataAccessObject gameStateDAO = new InMemoryGameStateDataAccessObject();
        InMemoryRoundStateDataAccessObject roundStateDAO = new InMemoryRoundStateDataAccessObject();
        InMemoryMessageHistoryDataAccessObject messageHistoryDAO = new InMemoryMessageHistoryDataAccessObject();
        InMemoryPlayerDataAccessObject playerDAO = new InMemoryPlayerDataAccessObject();
        InMemoryScoreboardScoreboardDataAccessObject scoreboardDAO = new InMemoryScoreboardScoreboardDataAccessObject();

        // Lone controllers and interactors to be placed in other views/items/etc.
        UpdateScoreInteractor updateScoreInteractor = UpdateScoreUseCaseFactory.create(scoreboardDAO, roundStateDAO, scoreboardViewModel);
        AddPlayerController addPlayerController = AddPlayerUseCaseFactory.create(scoreboardDAO, playerDAO, gameStateDAO, scoreboardViewModel);

        // Message logger
        MessageLogger messageLogger = MessageLoggerUseCaseFactory.create(messageHistoryDAO, playerDAO, sendMessageLoggerModel, chatViewModel, gameStateDAO, roundStateDAO, updateScoreInteractor);

        // todo remove later
        messageLogger.setChannel("1168619453492236424");

        // todo remove later
        Player brandon = new Player();
        brandon.setName("Brandon");
        gameStateDAO.getGameState().setMainPlayer(brandon);
        addPlayerController.execute(brandon);
//        gameStateDAO.addPlayer(me);
//        playerDAO.save(me);

        Player mark = new Player();
        mark.setName("Mark");
        addPlayerController.execute(mark);

        Player eric = new Player();
        eric.setName("eric");
        addPlayerController.execute(eric);
//        gameStateDAO.addPlayer(you);
//        playerDAO.save(you);

        // Views

        SingerChooseView singerChooseView = SingerChooseUseCaseFactory.create(viewManagerModel, singerChooseViewModel, roundStateDAO, singerSingViewModel);
        ScoreboardView scoreboardView = ScoreboardViewBuilder.createView(scoreboardViewModel);
        SingerSingView singerSingView = SingerSingUseCaseFactory.create(singerSingViewModel, scoreboardView);
        ChatView chatView = ChatUseCaseFactory.create(gameStateDAO, chatViewModel, sendMessageLoggerModel, playerGuessViewModel, gameStateDAO, roundStateDAO);
        EndScreenView endScreenView = EndScreenViewFactory.createView(endScreenViewModel);
        PlayerGuessView playerGuessView = PlayerGuessViewBuilder.createView(scoreboardView, chatView, playerGuessViewModel);

        views.add(singerChooseView, singerChooseView.viewName);
        views.add(singerSingView, singerSingView.viewName);
        views.add(endScreenView, endScreenView.viewName);
        // Keep this line commented out because otherwise the ChatView will not be added properly to the playerGuessView
        // views.add(chatView, chatView.viewName);
        views.add(playerGuessView, playerGuessView.viewName);

        // left in as tests, you may comment out RunGame controller to see how it works
        // endScreenViewModel.getState().setFirstPlace("Brandon", 100);
        // endScreenViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(endScreenView.viewName);

        viewManagerModel.firePropertyChanged();

        RunGameController runGameController = RunGameUseCaseFactory.createRunGameUseCase(gameStateDAO, roundStateDAO, playerDAO, gameStateDAO, playerGuessViewModel, singerChooseViewModel, singerSingViewModel, sendMessageLoggerModel, viewManagerModel);

        application.pack();
        application.setVisible(true);

        runGameController.execute(3, 10);
    }
}