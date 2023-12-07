package interface_adapter.EnterChooseName.HostEnterChooseName;

import interface_adapter.ChooseName.HostChooseNameViewModel;
import interface_adapter.ViewManagerModel;
import org.junit.Before;
import org.junit.Test;
import use_case.EnterChooseName.HostEnterChooseName.HostEnterChooseNameOutputData;

import static org.junit.Assert.*;

public class HostEnterChooseNamePresenterTest {

    HostEnterChooseNamePresenter hostEnterChooseNamePresenter;
    HostChooseNameViewModel hostChooseNameViewModel;
    ViewManagerModel viewManagerModel;
    @Before
    public void setUp() {
        hostChooseNameViewModel = new HostChooseNameViewModel();
        viewManagerModel = new ViewManagerModel();
        hostEnterChooseNamePresenter = new HostEnterChooseNamePresenter(hostChooseNameViewModel, viewManagerModel);

    }

    @Test
    public void prepareSuccessView() {
        HostEnterChooseNameOutputData hostEnterChooseNameOutputData = new HostEnterChooseNameOutputData("1");
        hostEnterChooseNamePresenter.prepareSuccessView(hostEnterChooseNameOutputData);
    }
}