package app;

import data_access.APIDataAccessObject;
import data_access.InMemoryGameStateGameStateDataAccessObject;
import data_access.InMemoryMessageMessageHistoryHistoryDataAccessObject;
import data_access.InMemoryPlayerDataAccessObject;
import entity.Song;
import interface_adapter.SingerChoose.SingerChooseState;
import interface_adapter.SingerChoose.SingerChooseViewModel;
import interface_adapter.ViewManagerModel;
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

        // View Models
        SingerChooseViewModel singerChooseViewModel = new SingerChooseViewModel();

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

        // DAOs
        InMemoryGameStateGameStateDataAccessObject GameStateDAO = new InMemoryGameStateGameStateDataAccessObject();
        InMemoryMessageMessageHistoryHistoryDataAccessObject messageHistoryDAO = new InMemoryMessageMessageHistoryHistoryDataAccessObject();
        InMemoryPlayerDataAccessObject playerDAO = new InMemoryPlayerDataAccessObject();

        // Views
        SingerChooseView singerChooseView = SingerChooseUseCaseFactory.create(viewManagerModel, singerChooseViewModel, GameStateDAO);

        views.add(singerChooseView, singerChooseView.viewName);

        viewManagerModel.setActiveView(singerChooseView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}