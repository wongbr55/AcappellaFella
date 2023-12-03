package use_case.EnterChooseName.JoinEnterChooseName;

public class JoinEnterChooseNameInteractor implements JoinEnterChooseNameInputBoundary {
    final JoinEnterChooseNameOutputBoundary joinEnterChooseNamePresenter;

    public JoinEnterChooseNameInteractor(JoinEnterChooseNameOutputBoundary joinEnterChooseNamePresenter) {
        this.joinEnterChooseNamePresenter = joinEnterChooseNamePresenter;
    }

    @Override
    public void execute(JoinEnterChooseNameInputData joinEnterChooseNameInputData) {
        JoinEnterChooseNameOutputData outputData = new JoinEnterChooseNameOutputData();
        joinEnterChooseNamePresenter.prepareSuccessView(outputData);
    }
}
