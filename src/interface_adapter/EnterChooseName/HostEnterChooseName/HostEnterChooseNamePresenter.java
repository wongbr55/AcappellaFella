package interface_adapter.EnterChooseName.HostEnterChooseName;

import interface_adapter.ChooseName.ChooseNameViewModel;
import interface_adapter.ViewManagerModel;
import use_case.EnterChooseName.HostEnterChooseName.HostEnterChooseNameOutputBoundary;
import use_case.EnterChooseName.HostEnterChooseName.HostEnterChooseNameOutputData;

public class HostEnterChooseNamePresenter implements HostEnterChooseNameOutputBoundary {
    private final ChooseNameViewModel chooseNameViewModel;
    private final ViewManagerModel viewManagerModel;

    public HostEnterChooseNamePresenter(ChooseNameViewModel chooseNameViewModel, ViewManagerModel viewManagerModel) {
        this.chooseNameViewModel = chooseNameViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(HostEnterChooseNameOutputData hostEnterChooseNameOutputData) {
        chooseNameViewModel.getState().setLobbyID(hostEnterChooseNameOutputData.getLobbyID());
        viewManagerModel.setActiveView(chooseNameViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
