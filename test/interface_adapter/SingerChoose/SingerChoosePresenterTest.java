package interface_adapter.SingerChoose;

import entity.Song;
import interface_adapter.SingerSing.SingerSingViewModel;
import interface_adapter.ViewManagerModel;
import org.junit.Before;
import org.junit.Test;
import use_case.SingerChoose.SingerChooseOutputData;

import static org.junit.Assert.*;

public class SingerChoosePresenterTest {

    private SingerChoosePresenter singerChoosePresenter;
    private SingerChooseViewModel singerChooseViewModel;
    private SingerSingViewModel singerSingViewModel;
    private ViewManagerModel viewManagerModel;


    @Before
    public void setUp(){
        singerChooseViewModel = new SingerChooseViewModel();
        singerSingViewModel = new SingerSingViewModel();
        viewManagerModel = new ViewManagerModel();
        singerChoosePresenter = new SingerChoosePresenter(viewManagerModel, singerChooseViewModel, singerSingViewModel);
    }

    @Test
    public void prepareSuccessView() {
        Song song = new Song("Queen", "Don't stop me now");
        SingerChooseOutputData singerChooseOutputData = new SingerChooseOutputData(song);
        singerChoosePresenter.prepareSuccessView(singerChooseOutputData);
    }
}