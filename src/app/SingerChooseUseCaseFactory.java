package app;

import interface_adapter.SingerChoose.SingerChooseController;
import interface_adapter.SingerChoose.SingerChoosePresenter;
import interface_adapter.SingerChoose.SingerChooseViewModel;
import interface_adapter.SingerSing.SingerSingViewModel;
import interface_adapter.ViewManagerModel;
import use_case.SingerChoose.SingerChooseInputBoundary;
import use_case.SingerChoose.SingerChooseInteractor;
import use_case.SingerChoose.SingerChooseOutputBoundary;
import use_case.SingerChoose.SingerChooseRoundStateDataAccessInterface;
import view.SingerChooseView;

public class SingerChooseUseCaseFactory {
    private SingerChooseUseCaseFactory() {
    }

    public static SingerChooseView create(ViewManagerModel viewManagerModel,
                                          SingerChooseViewModel singerChooseViewModel,
                                          SingerChooseRoundStateDataAccessInterface DAO, SingerSingViewModel singerSingViewModel) {
        SingerChooseController singerChooseController = createSingerChooseUseCase(viewManagerModel, singerChooseViewModel, DAO, singerSingViewModel);
        return new SingerChooseView(singerChooseViewModel, singerChooseController);
    }

    private static SingerChooseController createSingerChooseUseCase(ViewManagerModel viewManagerModel,
                                                                    SingerChooseViewModel singerChooseViewModel,
                                                                    SingerChooseRoundStateDataAccessInterface DAO, SingerSingViewModel singerSingViewModel) {

        // Notice how we pass this method's parameters to the Presenter.
        SingerChooseOutputBoundary singerChooseOutputBoundary = new SingerChoosePresenter(viewManagerModel, singerChooseViewModel, singerSingViewModel);

        SingerChooseInputBoundary singerChooseInteractor = new SingerChooseInteractor(
                DAO, singerChooseOutputBoundary);

        return new SingerChooseController(singerChooseInteractor);
    }
}
