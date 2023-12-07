package interface_adapter.RunGame;

import entity.Song;
import interface_adapter.EndScreen.EndScreenViewModel;
import interface_adapter.PlayerGuess.PlayerGuessViewModel;
import interface_adapter.SingerChoose.SingerChooseState;
import interface_adapter.SingerChoose.SingerChooseViewModel;
import interface_adapter.SingerSing.SingerSingViewModel;
import interface_adapter.ViewManagerModel;
import org.junit.Before;
import org.junit.Test;
import use_case.RunGame.RunGameGuessOutputData;
import use_case.RunGame.RunGameSingerChooseOutputData;
import use_case.RunGame.RunGameSingerSingOutputData;
import use_case.RunGame.RunGameUpdateTimerOutputData;

import static org.junit.Assert.*;

public class RunGamePresenterTest {

    private RunGamePresenter runGamePresenter;

    SingerChooseViewModel singerChooseViewModel;
    SingerSingViewModel singerSingViewModel;
    PlayerGuessViewModel playerGuessViewModel;
    ViewManagerModel viewManagerModel;
    EndScreenViewModel endScreenViewModel;

    @Before
    public void setUp() {
        singerChooseViewModel = new SingerChooseViewModel();
        singerSingViewModel = new SingerSingViewModel();
        playerGuessViewModel = new PlayerGuessViewModel();
        viewManagerModel = new ViewManagerModel();
        endScreenViewModel = new EndScreenViewModel();

        runGamePresenter = new RunGamePresenter(singerChooseViewModel, singerSingViewModel, playerGuessViewModel, viewManagerModel, endScreenViewModel);
    }

    @Test
    public void prepareSingerChooseView() {
        RunGameSingerChooseOutputData runGameSingerChooseOutputData = new RunGameSingerChooseOutputData(new SingerChooseState());
        runGamePresenter.prepareSingerChooseView(runGameSingerChooseOutputData);
    }

    @Test
    public void prepareSingerSingView() {
        Song song = new Song("Arctic Monkeys", "Do I wanna know");

        RunGameSingerSingOutputData runGameSingerSingOutputData = new RunGameSingerSingOutputData(song);
        runGamePresenter.prepareSingerSingView(runGameSingerSingOutputData);

        assertEquals(song.toString(), singerSingViewModel.getState().getSongLabel());
    }

    @Test
    public void prepareGuessView() {
        RunGameGuessOutputData runGameGuessOutputData = new RunGameGuessOutputData();
        runGamePresenter.prepareGuessView(runGameGuessOutputData);
    }

    @Test
    public void updateSingerChooseTimer() {
        RunGameUpdateTimerOutputData runGameUpdateTimerOutputData = new RunGameUpdateTimerOutputData(1);
        runGamePresenter.updateSingerChooseTimer(runGameUpdateTimerOutputData);
    }

    @Test
    public void updateSingerSingTimer() {
        RunGameUpdateTimerOutputData runGameUpdateTimerOutputData = new RunGameUpdateTimerOutputData(1);
        runGamePresenter.updateSingerSingTimer(runGameUpdateTimerOutputData);
    }

    @Test
    public void updateGuessTimer() {
        RunGameUpdateTimerOutputData runGameUpdateTimerOutputData = new RunGameUpdateTimerOutputData(1);
        runGamePresenter.updateGuessTimer(runGameUpdateTimerOutputData);
    }
}