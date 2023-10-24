package use_case.SingerChoose;

public interface SingerChooseOutputBoundary {
    void prepareSuccessView(SingerChooseOutputData singerChooseOutputData);
    void prepareFailView(String error);
}
