package use_case.RunGame;

import interface_adapter.SingerChoose.SingerChooseState;

public class RunGameSingerChooseOutputData {
    // todo possibly violating CA
    private final SingerChooseState singerChooseState;

    public RunGameSingerChooseOutputData(SingerChooseState singerChooseState) {
        this.singerChooseState = singerChooseState;
    }
}
