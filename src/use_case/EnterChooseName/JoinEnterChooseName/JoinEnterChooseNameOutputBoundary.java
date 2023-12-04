package use_case.EnterChooseName.JoinEnterChooseName;

public interface JoinEnterChooseNameOutputBoundary {
    void prepareSuccessView(JoinEnterChooseNameOutputData joinEnterChooseNameOutputData);
    void prepareFailView(String error);
}
