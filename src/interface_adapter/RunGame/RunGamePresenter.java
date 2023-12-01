package interface_adapter.RunGame;

import entity.Song;
import interface_adapter.PlayerGuess.PlayerGuessViewModel;
import interface_adapter.SingerChoose.SingerChoosePresenter;
import interface_adapter.SingerChoose.SingerChooseState;
import interface_adapter.SingerChoose.SingerChooseViewModel;
import interface_adapter.SingerSing.SingerSingViewModel;
import interface_adapter.ViewManagerModel;
import use_case.RunGame.*;

public class RunGamePresenter implements RunGameOutputBoundary {
    private final SingerChooseViewModel singerChooseViewModel;
    private final SingerSingViewModel singerSingViewModel;
    private final PlayerGuessViewModel playerGuessViewModel;
    private final ViewManagerModel viewManagerModel;

    public RunGamePresenter(SingerChooseViewModel singerChooseViewModel,
                            SingerSingViewModel singerSingViewModel,
                            PlayerGuessViewModel playerGuessViewModel,
                            ViewManagerModel viewManagerModel) {
        this.playerGuessViewModel = playerGuessViewModel;
        this.singerChooseViewModel = singerChooseViewModel;
        this.singerSingViewModel = singerSingViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSingerChooseView(RunGameSingerChooseOutputData runGameSingerChooseOutputData) {
        singerChooseViewModel.setState(runGameSingerChooseOutputData.getSingerChooseState());
        singerChooseViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(singerChooseViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareSingerSingView(RunGameSingerSingOutputData runGameSingerSingOutputData) {
        singerSingViewModel.getState().setSongLabel(runGameSingerSingOutputData.getSong().toString());
        singerSingViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(singerSingViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareGuessView(RunGameGuessOutputData runGameGuessOutputData) {
        viewManagerModel.setActiveView(playerGuessViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void updateSingerChooseTimer(RunGameUpdateTimerOutputData runGameUpdateTimerOutputData) {
        singerChooseViewModel.getState().setTime(String.valueOf(runGameUpdateTimerOutputData.getTime()));
        singerChooseViewModel.firePropertyChanged();
    }

    @Override
    public void updateSingerSingTimer(RunGameUpdateTimerOutputData runGameUpdateTimerOutputData) {
        singerSingViewModel.getState().setTime(String.valueOf(runGameUpdateTimerOutputData.getTime()));
        singerSingViewModel.firePropertyChanged();
    }

    @Override
    public void updateGuessTimer(RunGameUpdateTimerOutputData runGameUpdateTimerOutputData) {
        playerGuessViewModel.getState().setTime(String.valueOf(runGameUpdateTimerOutputData.getTime()));
        playerGuessViewModel.firePropertyChanged();
    }
}
