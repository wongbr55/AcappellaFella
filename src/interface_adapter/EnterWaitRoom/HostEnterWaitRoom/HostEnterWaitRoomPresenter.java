package interface_adapter.EnterWaitRoom.HostEnterWaitRoom;

import interface_adapter.ChooseName.HostChooseNameViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.WaitRoom.HostWaitRoomViewModel;
import use_case.EnterWaitRoom.HostEnterWaitRoom.HostEnterWaitRoomOutputBoundary;
import use_case.EnterWaitRoom.HostEnterWaitRoom.HostEnterWaitRoomOutputData;

public class HostEnterWaitRoomPresenter implements HostEnterWaitRoomOutputBoundary {
    private final HostWaitRoomViewModel hostWaitRoomViewModel;
    private final HostChooseNameViewModel hostChooseNameViewModel;
    private final ViewManagerModel viewManagerModel;

    public HostEnterWaitRoomPresenter(HostWaitRoomViewModel hostWaitRoomViewModel, HostChooseNameViewModel hostChooseNameViewModel, ViewManagerModel viewManagerModel) {
        this.hostWaitRoomViewModel = hostWaitRoomViewModel;
        this.hostChooseNameViewModel = hostChooseNameViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(HostEnterWaitRoomOutputData hostEnterWaitRoomOutputData) {
        hostWaitRoomViewModel.getState().setLobbyID(hostEnterWaitRoomOutputData.getLobbyID());
        hostWaitRoomViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(hostWaitRoomViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        hostChooseNameViewModel.getState().setNameError(error);
        hostChooseNameViewModel.firePropertyChanged();
    }
}
