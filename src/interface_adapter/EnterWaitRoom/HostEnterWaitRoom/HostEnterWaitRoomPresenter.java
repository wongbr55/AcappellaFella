package interface_adapter.EnterWaitRoom.HostEnterWaitRoom;

import interface_adapter.ViewManagerModel;
import interface_adapter.WaitRoom.HostWaitRoomViewModel;
import use_case.EnterWaitRoom.HostEnterWaitRoom.HostEnterWaitRoomOutputBoundary;
import use_case.EnterWaitRoom.HostEnterWaitRoom.HostEnterWaitRoomOutputData;

public class HostEnterWaitRoomPresenter implements HostEnterWaitRoomOutputBoundary {
    private final HostWaitRoomViewModel hostWaitRoomViewModel;
    private final ViewManagerModel viewManagerModel;

    public HostEnterWaitRoomPresenter(HostWaitRoomViewModel hostWaitRoomViewModel, ViewManagerModel viewManagerModel) {
        this.hostWaitRoomViewModel = hostWaitRoomViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(HostEnterWaitRoomOutputData hostEnterWaitRoomOutputData) {

    }
}
