package interface_adapter.ChooseName.JoinChooseName;

import use_case.ChooseName.JoinChooseName.JoinChooseNameInputBoundary;
import use_case.ChooseName.JoinChooseName.JoinChooseNameInputData;

public class JoinChooseNameController {
    final JoinChooseNameInputBoundary joinChooseNameInteractor;

    public JoinChooseNameController(JoinChooseNameInputBoundary joinChooseNameInteractor) {
        this.joinChooseNameInteractor = joinChooseNameInteractor;
    }

    void execute() {
        JoinChooseNameInputData inputData = new JoinChooseNameInputData();
        joinChooseNameInteractor.execute(inputData);
    }
}
