package use_case.SingerChoose;

import entity.GameState;

public class SingerChooseInteractor implements SingerChooseInputBoundary {
    final SingerChooseDataAccessInterface singerChooseDAO;
    final SingerChooseOutputBoundary singerChoosePresenter;

    public SingerChooseInteractor(SingerChooseDataAccessInterface singerChooseDAO, SingerChooseOutputBoundary singerChoosePresenter) {
        this.singerChooseDAO = singerChooseDAO;
        this.singerChoosePresenter = singerChoosePresenter;
    }

    @Override
    public void execute(SingerChooseInputData singerChooseInputData) {
        // Get the current game state and change the song
        GameState gameState = GameState.getInstance();
        gameState.setSong(singerChooseInputData.getSong());
        // prepare success view
        SingerChooseOutputData singerChooseOutputData = new SingerChooseOutputData();
        singerChoosePresenter.prepareSuccessView(singerChooseOutputData);
    }
}
