package app;

import data_access.APIDataAccessObject;
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
        APIDataAccessObject DAO = new APIDataAccessObject();

        SingerChooseView singerChooseView = SingerChooseUseCaseFactory.create(viewManagerModel, singerChooseViewModel, DAO);

        views.add(singerChooseView, singerChooseView.viewName);

        viewManagerModel.setActiveView(singerChooseView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}