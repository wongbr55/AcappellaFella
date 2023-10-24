package interface_adapter.SingerChoose;

import use_case.SingerChoose.SingerChooseInputBoundary;
import use_case.SingerChoose.SingerChooseInputData;
import use_case.SingerChoose.SingerChooseInteractor;

public class SingerChooseController {
    final SingerChooseInputBoundary singerChooseInteractor;

    public SingerChooseController(SingerChooseInputBoundary singerChooseInteractor) {
        this.singerChooseInteractor = singerChooseInteractor;
    }

    public void execute(SingerChooseInputData singerChooseInputData) {
        singerChooseInteractor.execute(singerChooseInputData);
    }
}
