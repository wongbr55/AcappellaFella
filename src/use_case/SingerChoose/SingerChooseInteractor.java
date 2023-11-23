package use_case.SingerChoose;

import entity.RoundState;

public class SingerChooseInteractor implements SingerChooseInputBoundary {
    final SingerChooseRoundStateDataAccessInterface singerChooseRoundStateDataAccessObject;
    final SingerChooseOutputBoundary singerChoosePresenter;

    public SingerChooseInteractor(SingerChooseRoundStateDataAccessInterface singerChooseRoundStateDataAccessObject, SingerChooseOutputBoundary singerChoosePresenter) {
        this.singerChooseRoundStateDataAccessObject = singerChooseRoundStateDataAccessObject;
        this.singerChoosePresenter = singerChoosePresenter;
    }

    @Override
    public void execute(SingerChooseInputData singerChooseInputData) {
        // Get the current game state and change the song
        RoundState roundState = singerChooseRoundStateDataAccessObject.getCurrentRoundState();
        roundState.setSong(singerChooseInputData.getSong());
        roundState.setSingerState(RoundState.SingerState.SINGING);

        // REDUNDANT NOW: the RunGameInteractor handles changing views and stuff
        // prepare success view
        // SingerChooseOutputData singerChooseOutputData = new SingerChooseOutputData(singerChooseInputData.getSong());
        // singerChoosePresenter.prepareSuccessView(singerChooseOutputData);
    }
}
