package use_case.EnterChooseName.JoinEnterChooseName;

public class JoinEnterChooseNameInteractor implements JoinEnterChooseNameInputBoundary {
    final JoinEnterChooseNameOutputBoundary joinEnterChooseNamePresenter;

    public JoinEnterChooseNameInteractor(JoinEnterChooseNameOutputBoundary joinEnterChooseNamePresenter) {
        this.joinEnterChooseNamePresenter = joinEnterChooseNamePresenter;
    }

    @Override
    public void execute(JoinEnterChooseNameInputData joinEnterChooseNameInputData) {
        if (!joinEnterChooseNameInputData.getLobbyID().isEmpty()) {
            JoinEnterChooseNameOutputData outputData = new JoinEnterChooseNameOutputData(joinEnterChooseNameInputData.getLobbyID());
            joinEnterChooseNamePresenter.prepareSuccessView(outputData);
        } else {
            joinEnterChooseNamePresenter.prepareFailView("LobbyID does not exist");
        }
    }
}
