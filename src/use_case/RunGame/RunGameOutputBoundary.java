package use_case.RunGame;

public interface RunGameOutputBoundary {
    void prepareSingerChooseView(RunGameSingerChooseOutputData runGameSingerChooseOutputData);
    void prepareSingerSingView(RunGameSingerSingOutputData runGameSingerSingOutputData);
    void prepareGuessView(RunGameGuessOutputData runGameGuessOutputData);
}
