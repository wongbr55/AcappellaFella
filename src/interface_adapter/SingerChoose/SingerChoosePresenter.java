package interface_adapter.SingerChoose;

import interface_adapter.SingerSing.SingerSingViewModel;
import interface_adapter.ViewManagerModel;
import use_case.SingerChoose.SingerChooseOutputBoundary;
import use_case.SingerChoose.SingerChooseOutputData;

public class SingerChoosePresenter implements SingerChooseOutputBoundary {
    private final SingerChooseViewModel singerChooseViewModel;

    private final SingerSingViewModel singerSingViewModel;
    private final ViewManagerModel viewManagerModel;

    public SingerChoosePresenter(ViewManagerModel viewManagerModel, SingerChooseViewModel singerChooseViewModel, SingerSingViewModel singerSingViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.singerChooseViewModel = singerChooseViewModel;
        this.singerSingViewModel = singerSingViewModel;
    }

    @Override
    public void prepareSuccessView(SingerChooseOutputData singerChooseOutputData) {
        // Switch to SingerSing View
        singerSingViewModel.setSongLabel(singerChooseOutputData.getSong().toString());
        singerSingViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(singerSingViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {

    }
}
