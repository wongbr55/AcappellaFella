package interface_adapter.RunGame;

import entity.Song;
import interface_adapter.PlayerGuess.PlayerGuessViewModel;
import interface_adapter.SingerChoose.SingerChoosePresenter;
import interface_adapter.SingerChoose.SingerChooseState;
import interface_adapter.SingerChoose.SingerChooseViewModel;
import interface_adapter.SingerSing.SingerSingViewModel;
import interface_adapter.ViewManagerModel;
import use_case.RunGame.RunGameGuessOutputData;
import use_case.RunGame.RunGameOutputBoundary;
import use_case.RunGame.RunGameSingerChooseOutputData;
import use_case.RunGame.RunGameSingerSingOutputData;

public class RunGamePresenter implements RunGameOutputBoundary {
    private final PlayerGuessViewModel playerGuessViewModel;
    private final SingerChooseViewModel singerChooseViewModel;
    private final SingerSingViewModel singerSingViewModel;
    private final ViewManagerModel viewManagerModel;

    public RunGamePresenter(PlayerGuessViewModel playerGuessViewModel,
                            SingerChooseViewModel singerChooseViewModel,
                            SingerSingViewModel singerSingViewModel,
                            ViewManagerModel viewManagerModel) {
        this.playerGuessViewModel = playerGuessViewModel;
        this.singerChooseViewModel = singerChooseViewModel;
        this.singerSingViewModel = singerSingViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSingerChooseView(RunGameSingerChooseOutputData runGameSingerChooseOutputData) {
        SingerChooseState singerChooseState = singerChooseViewModel.getState();
        Song song1 = new Song("Queen", "Don't Stop Me now");
        Song song2 = new Song("Queen", "Bohemian Rhapsody");
        Song song3 = new Song("Queen", "Another One Bites The Dust");
        singerChooseState.setSong1(song1);
        singerChooseState.setSong2(song2);
        singerChooseState.setSong3(song3);
        singerChooseViewModel.setState(singerChooseState);
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
}
