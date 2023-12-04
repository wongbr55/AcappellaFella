package interface_adapter.EnterWaitRoom.JoinEnterWaitRoom;

import interface_adapter.ChooseName.JoinChooseNameViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.WaitRoom.JoinWaitRoomViewModel;
import use_case.EnterWaitRoom.JoinEnterWaitRoom.JoinEnterWaitRoomOutputBoundary;
import use_case.EnterWaitRoom.JoinEnterWaitRoom.JoinEnterWaitRoomOutputData;

public class JoinEnterWaitRoomPresenter implements JoinEnterWaitRoomOutputBoundary {
    private final JoinWaitRoomViewModel joinWaitRoomViewModel;
    private final JoinChooseNameViewModel joinChooseNameViewModel;
    private final ViewManagerModel viewManagerModel;

    public JoinEnterWaitRoomPresenter(JoinWaitRoomViewModel joinWaitRoomViewModel, JoinChooseNameViewModel joinChooseNameViewModel, ViewManagerModel viewManagerModel) {
        this.joinWaitRoomViewModel = joinWaitRoomViewModel;
        this.joinChooseNameViewModel = joinChooseNameViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(JoinEnterWaitRoomOutputData joinEnterWaitRoomOutputData) {
        joinWaitRoomViewModel.getState().setLobbyID(joinEnterWaitRoomOutputData.getLobbyID());
        joinWaitRoomViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(joinWaitRoomViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        joinChooseNameViewModel.getState().setNameError(error);
        joinChooseNameViewModel.firePropertyChanged();
    }
}
