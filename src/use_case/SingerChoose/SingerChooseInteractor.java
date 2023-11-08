package use_case.SingerChoose;

public class SingerChooseInteractor implements SingerChooseInputBoundary {
    final SingerChooseGameStateDataAccessInterface singerChooseGameStateDataAccessObject;
    final SingerChooseOutputBoundary singerChoosePresenter;

    public SingerChooseInteractor(SingerChooseGameStateDataAccessInterface singerChooseGameStateDataAccessObject, SingerChooseOutputBoundary singerChoosePresenter) {
        this.singerChooseGameStateDataAccessObject = singerChooseGameStateDataAccessObject;
        this.singerChoosePresenter = singerChoosePresenter;
    }

    @Override
    public void execute(SingerChooseInputData singerChooseInputData) {
        // Get the current game state and change the song
        singerChooseGameStateDataAccessObject.getGameState().setSong(singerChooseInputData.getSong());
        // prepare success view
        SingerChooseOutputData singerChooseOutputData = new SingerChooseOutputData();
        singerChoosePresenter.prepareSuccessView(singerChooseOutputData);
    }
}
