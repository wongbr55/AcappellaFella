package interface_adapter.EnterChooseName.JoinEnterChooseName;

import interface_adapter.ChooseName.JoinChooseNameViewModel;
import interface_adapter.Home.HomeViewModel;
import interface_adapter.ViewManagerModel;
import org.junit.Before;
import org.junit.Test;
import use_case.EnterChooseName.JoinEnterChooseName.JoinEnterChooseNameOutputBoundary;
import use_case.EnterChooseName.JoinEnterChooseName.JoinEnterChooseNameOutputData;

import static org.junit.Assert.*;

public class JoinEnterChooseNamePresenterTest {

    JoinEnterChooseNamePresenter joinEnterChooseNamePresenter;
    JoinChooseNameViewModel joinChooseNameViewModel;
    HomeViewModel homeViewModel;

    ViewManagerModel viewManagerModel;
    @Before
    public void setUp() {
        joinChooseNameViewModel = new JoinChooseNameViewModel();
        homeViewModel = new HomeViewModel();
        viewManagerModel = new ViewManagerModel();
        joinEnterChooseNamePresenter = new JoinEnterChooseNamePresenter(joinChooseNameViewModel, homeViewModel, viewManagerModel);
    }

    @Test
    public void prepareSuccessView() {
        JoinEnterChooseNameOutputData joinEnterChooseNameOutputData = new JoinEnterChooseNameOutputData("1");
        joinEnterChooseNamePresenter.prepareSuccessView(joinEnterChooseNameOutputData);
    }

    @Test
    public void prepareFailView() {
        joinEnterChooseNamePresenter.prepareFailView("Error");
    }
}