package use_case.EnterChooseName.HostEnterChooseName;

public class HostEnterChooseNameInteractor implements HostEnterChooseNameInputBoundary {
    final HostEnterChooseNameOutputBoundary hostEnterChooseNamePresenter;

    public HostEnterChooseNameInteractor(HostEnterChooseNameOutputBoundary hostEnterChooseNamePresenter) {
        this.hostEnterChooseNamePresenter = hostEnterChooseNamePresenter;
    }

    @Override
    public void execute(HostEnterChooseNameInputData hostEnterChooseNameInputData) {

    }
}
