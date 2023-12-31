package interface_adapter.SingerChoose;

import entity.Song;
import use_case.SingerChoose.SingerChooseInputBoundary;
import use_case.SingerChoose.SingerChooseInputData;

public class SingerChooseController {
    final SingerChooseInputBoundary singerChooseInteractor;

    public SingerChooseController(SingerChooseInputBoundary singerChooseInteractor) {
        this.singerChooseInteractor = singerChooseInteractor;
    }

    public void execute(String songName) {
        SingerChooseInputData singerChooseInputData = new SingerChooseInputData(songName);
        singerChooseInteractor.execute(singerChooseInputData);
    }
}
