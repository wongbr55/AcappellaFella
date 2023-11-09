package app;

import data_access.InMemoryGameStateGameStateDataAccessObject;
import data_access.InMemoryMessageHistoryDataAccessObject;
import data_access.InMemoryPlayerDataAccessObject;
import data_access.InMemoryRoundStateDataAccessObject;
import entity.Player;
import entity.Song;
import interface_adapter.Chat.ChatViewModel;
import interface_adapter.CheckGuess.CheckGuessViewModel;
import interface_adapter.SendMessage.SendMessageLoggerModel;
import interface_adapter.SingerChoose.SingerChooseState;
import interface_adapter.SingerChoose.SingerChooseViewModel;
import interface_adapter.ViewManagerModel;
import logger.MessageLogger;
import view.ChatView;
import view.PlayerGuessView;
import view.SingerChooseView;
import view.ViewManager;

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

        // View Models
        SingerChooseViewModel singerChooseViewModel = new SingerChooseViewModel();
        ChatViewModel chatViewModel = new ChatViewModel();
        CheckGuessViewModel checkGuessViewModel = new CheckGuessViewModel();

        // DAOs
        InMemoryGameStateGameStateDataAccessObject gameStateDAO = new InMemoryGameStateGameStateDataAccessObject();
        InMemoryRoundStateDataAccessObject roundStateDAO = new InMemoryRoundStateDataAccessObject();
        InMemoryMessageHistoryDataAccessObject messageHistoryDAO = new InMemoryMessageHistoryDataAccessObject();
        InMemoryPlayerDataAccessObject playerDAO = new InMemoryPlayerDataAccessObject();

        // Message logger
        MessageLogger messageLogger = MessageLoggerUseCaseFactory.create(messageHistoryDAO, playerDAO, sendMessageLoggerModel, chatViewModel, gameStateDAO, roundStateDAO);

        /*
         todo remove later
         temp init for singerChooseViewModel
         needs to go in the RunGame use case somewhere
        */
        SingerChooseState singerChooseState = singerChooseViewModel.getState();
        Song song1 = new Song("Queen", "Don't Stop Me now");
        Song song2 = new Song("Queen", "Bohemian Rhapsody");
        Song song3 = new Song("Queen", "Another One Bites The Dust");
        singerChooseState.setSong1(song1);
        singerChooseState.setSong2(song2);
        singerChooseState.setSong3(song3);
        singerChooseViewModel.setState(singerChooseState);


        // todo remove later
        // set a song for testing
        gameStateDAO.getGameState().setSong(song1);

        //todo remove later
        roundStateDAO.addRound();


        // todo remove later
        messageLogger.setChannel("1168619453492236424");

        // todo remove later
        Player me = new Player();
        me.setName("Brandon");
        gameStateDAO.getGameState().setMainPlayer(me);
        gameStateDAO.addPlayer(me);
        playerDAO.save(me);

        Player you = new Player();
        you.setName("eric");
        gameStateDAO.addPlayer(you);
        playerDAO.save(you);

        // Views
        SingerChooseView singerChooseView = SingerChooseUseCaseFactory.create(viewManagerModel, singerChooseViewModel, gameStateDAO);
        ChatView chatView = ChatUseCaseFactory.create(gameStateDAO, chatViewModel, sendMessageLoggerModel, checkGuessViewModel, gameStateDAO, roundStateDAO);
        PlayerGuessView playerGuessView = PlayerGuessViewBuilder.createView(chatView, checkGuessViewModel);

        views.add(singerChooseView, singerChooseView.viewName);
        // Keep this line commented out because otherwise the ChatView will not be added properly to the playerGuessView
        // views.add(chatView, chatView.viewName);
        views.add(playerGuessView, playerGuessView.viewName);

        viewManagerModel.setActiveView(playerGuessView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}