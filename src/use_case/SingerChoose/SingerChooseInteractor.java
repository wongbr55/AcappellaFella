package use_case.SingerChoose;

import entity.GameState;

public class SingerChooseInteractor implements SingerChooseInputBoundary {
    final SingerChooseDataAccessInterface singerChooseDAO;
    final SingerChooseOutputBoundary singerChoosePresenter;
    final GameState gameState = GameState.getInstance();

    public SingerChooseInteractor(SingerChooseDataAccessInterface singerChooseDAO, SingerChooseOutputBoundary singerChoosePresenter) {
        this.singerChooseDAO = singerChooseDAO;
        this.singerChoosePresenter = singerChoosePresenter;
    }

    @Override
    public void execute(SingerChooseInputData singerChooseInputData) {
        // Get the current game state and change the song
        gameState.setSong(singerChooseInputData.getSong());
        // prepare success view
        SingerChooseOutputData singerChooseOutputData = new SingerChooseOutputData();
        singerChoosePresenter.prepareSuccessView(singerChooseOutputData);
    }
}
