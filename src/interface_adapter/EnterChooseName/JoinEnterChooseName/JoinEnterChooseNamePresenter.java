package interface_adapter.EnterChooseName.JoinEnterChooseName;

import interface_adapter.ChooseName.JoinChooseNameViewModel;
import interface_adapter.Home.HomeViewModel;
import interface_adapter.ViewManagerModel;
import use_case.EnterChooseName.JoinEnterChooseName.JoinEnterChooseNameOutputBoundary;
import use_case.EnterChooseName.JoinEnterChooseName.JoinEnterChooseNameOutputData;

public class JoinEnterChooseNamePresenter implements JoinEnterChooseNameOutputBoundary {
    private final JoinChooseNameViewModel joinChooseNameViewModel;
    private final HomeViewModel homeViewModel;
    private final ViewManagerModel viewManagerModel;

    public JoinEnterChooseNamePresenter(JoinChooseNameViewModel joinChooseNameViewModel, HomeViewModel homeViewModel, ViewManagerModel viewManagerModel) {
        this.joinChooseNameViewModel = joinChooseNameViewModel;
        this.homeViewModel = homeViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(JoinEnterChooseNameOutputData joinEnterChooseNameOutputData) {
        joinChooseNameViewModel.getState().setLobbyID(joinEnterChooseNameOutputData.getLobbyID());
        viewManagerModel.setActiveView(joinChooseNameViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        homeViewModel.getState().setLobbyIDError(error);
        homeViewModel.firePropertyChanged();
    }
}
