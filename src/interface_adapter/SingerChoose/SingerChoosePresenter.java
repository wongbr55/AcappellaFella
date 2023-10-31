package interface_adapter.SingerChoose;

import interface_adapter.ViewManagerModel;
import use_case.SingerChoose.SingerChooseOutputBoundary;
import use_case.SingerChoose.SingerChooseOutputData;

public class SingerChoosePresenter implements SingerChooseOutputBoundary {
    private final SingerChooseViewModel singerChooseViewModel;
    private ViewManagerModel viewManagerModel;

    public SingerChoosePresenter(ViewManagerModel viewManagerModel, SingerChooseViewModel singerChooseViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.singerChooseViewModel = singerChooseViewModel;
    }

    @Override
    public void prepareSuccessView(SingerChooseOutputData singerChooseOutputData) {
        // todo
    }

    @Override
    public void prepareFailView(String error) {
        // todo
    }
}
