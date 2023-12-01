package interface_adapter.ChooseName.HostChooseName;

import use_case.ChooseName.HostChooseName.HostChooseNameInputBoundary;
import use_case.ChooseName.HostChooseName.HostChooseNameInputData;

public class HostChooseNameController {
    final HostChooseNameInputBoundary hostChooseNameInteractor;

    public HostChooseNameController(HostChooseNameInputBoundary hostChooseNameInteractor) {
        this.hostChooseNameInteractor = hostChooseNameInteractor;
    }

    void execute(String lobbyID) {
        HostChooseNameInputData inputData = new HostChooseNameInputData();
        hostChooseNameInteractor.execute(inputData);
    }
}
