package use_case.SingerChoose;

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
        singerChooseRoundStateDataAccessObject.getCurrentRoundState().setSong(singerChooseInputData.getSong());
        // prepare success view

        SingerChooseOutputData singerChooseOutputData = new SingerChooseOutputData(singerChooseInputData.getSong());
        singerChoosePresenter.prepareSuccessView(singerChooseOutputData);
    }
}
