package use_case.RunGame;

import use_case.SingerChoose.SingerChooseOutputData;

public interface RunGameOutputBoundary {
    void prepareSingView(RunGameSingOutputData runGameSingOutputData);
    void prepareGuessView(RunGameGuessOutputData runGameGuessOutputData);
}
