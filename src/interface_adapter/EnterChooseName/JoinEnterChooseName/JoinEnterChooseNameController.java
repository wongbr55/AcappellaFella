package interface_adapter.EnterChooseName.JoinEnterChooseName;

import use_case.EnterChooseName.JoinEnterChooseName.JoinEnterChooseNameInputBoundary;
import use_case.EnterChooseName.JoinEnterChooseName.JoinEnterChooseNameInputData;

public class JoinEnterChooseNameController {
    final JoinEnterChooseNameInputBoundary joinEnterChooseNameInteractor;

    public JoinEnterChooseNameController(JoinEnterChooseNameInputBoundary joinEnterChooseNameInteractor) {
        this.joinEnterChooseNameInteractor = joinEnterChooseNameInteractor;
    }

    public void execute() {
        JoinEnterChooseNameInputData inputData = new JoinEnterChooseNameInputData();
        joinEnterChooseNameInteractor.execute(inputData);
    }
}
