package interface_adapter.EnterChooseName.HostEnterChooseName;

import use_case.EnterChooseName.HostEnterChooseName.HostEnterChooseNameInputBoundary;
import use_case.EnterChooseName.HostEnterChooseName.HostEnterChooseNameInputData;

public class HostEnterChooseNameController {
    final HostEnterChooseNameInputBoundary hostEnterChooseNameInteractor;

    public HostEnterChooseNameController(HostEnterChooseNameInputBoundary hostEnterChooseNameInteractor) {
        this.hostEnterChooseNameInteractor = hostEnterChooseNameInteractor;
    }

    void execute(String lobbyID) {
        HostEnterChooseNameInputData inputData = new HostEnterChooseNameInputData();
        hostEnterChooseNameInteractor.execute(inputData);
    }
}
