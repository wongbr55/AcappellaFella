package use_case.ChooseName.HostChooseName;

public class HostChooseNameInteractor implements HostChooseNameInputBoundary {
    final HostChooseNameOutputBoundary hostChooseNamePresenter;

    public HostChooseNameInteractor(HostChooseNameOutputBoundary hostChooseNamePresenter) {
        this.hostChooseNamePresenter = hostChooseNamePresenter;
    }

    @Override
    public void execute(HostChooseNameInputData hostChooseNameInputData) {

    }
}
