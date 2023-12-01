package use_case.RunGame;

import interface_adapter.SingerChoose.SingerChooseState;

public class RunGameSingerChooseOutputData {
    private final SingerChooseState singerChooseState;

    public RunGameSingerChooseOutputData(SingerChooseState singerChooseState) {
        this.singerChooseState = singerChooseState;
    }

    public SingerChooseState getSingerChooseState() {
        return singerChooseState;
    }
}
