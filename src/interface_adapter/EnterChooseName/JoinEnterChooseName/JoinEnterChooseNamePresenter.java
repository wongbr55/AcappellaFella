package interface_adapter.EnterChooseName.JoinEnterChooseName;

import interface_adapter.ChooseName.JoinChooseNameViewModel;
import interface_adapter.ViewManagerModel;
import use_case.EnterChooseName.JoinEnterChooseName.JoinEnterChooseNameOutputBoundary;
import use_case.EnterChooseName.JoinEnterChooseName.JoinEnterChooseNameOutputData;

public class JoinEnterChooseNamePresenter implements JoinEnterChooseNameOutputBoundary {
    private final JoinChooseNameViewModel joinChooseNameViewModel;
    private final ViewManagerModel viewManagerModel;

    public JoinEnterChooseNamePresenter(JoinChooseNameViewModel joinChooseNameViewModel, ViewManagerModel viewManagerModel) {
        this.joinChooseNameViewModel = joinChooseNameViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(JoinEnterChooseNameOutputData joinEnterChooseNameOutputData) {
        viewManagerModel.setActiveView(joinChooseNameViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
