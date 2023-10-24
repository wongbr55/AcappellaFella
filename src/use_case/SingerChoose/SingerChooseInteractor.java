package use_case.SingerChoose;

public class SingerChooseInteractor implements SingerChooseInputBoundary {
    final SingerChooseDataAccessInterface singerChooseDAO;
    final SingerChooseOutputBoundary singerChoosePresenter;

    public SingerChooseInteractor(SingerChooseDataAccessInterface singerChooseDAO, SingerChooseOutputBoundary singerChoosePresenter) {
        this.singerChooseDAO = singerChooseDAO;
        this.singerChoosePresenter = singerChoosePresenter;
    }

    @Override
    public void execute(SingerChooseInputData singerChooseInputdata) {

    }
}
