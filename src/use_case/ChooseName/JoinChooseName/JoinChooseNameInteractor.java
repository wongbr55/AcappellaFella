package use_case.ChooseName.JoinChooseName;

public class JoinChooseNameInteractor implements JoinChooseNameInputBoundary {
    final JoinChooseNameOutputBoundary joinChooseNamePresenter;

    public JoinChooseNameInteractor(JoinChooseNameOutputBoundary joinChooseNamePresenter) {
        this.joinChooseNamePresenter = joinChooseNamePresenter;
    }

    @Override
    public void execute(JoinChooseNameInputData joinChooseNameInputData) {

    }
}
