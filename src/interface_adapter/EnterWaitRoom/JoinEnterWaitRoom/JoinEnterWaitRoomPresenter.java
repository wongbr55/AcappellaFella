package interface_adapter.EnterWaitRoom.JoinEnterWaitRoom;

import interface_adapter.ViewManagerModel;
import interface_adapter.WaitRoom.JoinWaitRoomViewModel;
import use_case.EnterWaitRoom.JoinEnterWaitRoom.JoinEnterWaitRoomOutputBoundary;
import use_case.EnterWaitRoom.JoinEnterWaitRoom.JoinEnterWaitRoomOutputData;

public class JoinEnterWaitRoomPresenter implements JoinEnterWaitRoomOutputBoundary {
    private final JoinWaitRoomViewModel joinWaitRoomViewModel;
    private final ViewManagerModel viewManagerModel;

    public JoinEnterWaitRoomPresenter(JoinWaitRoomViewModel joinWaitRoomViewModel, ViewManagerModel viewManagerModel) {
        this.joinWaitRoomViewModel = joinWaitRoomViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(JoinEnterWaitRoomOutputData joinEnterWaitRoomOutputData) {

    }
}
