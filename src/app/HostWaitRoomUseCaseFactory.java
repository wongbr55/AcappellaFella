package app;

import interface_adapter.RunGame.RunGameController;
import interface_adapter.WaitRoom.WaitRoomViewModel;
import view.HostWaitRoomView;

public class HostWaitRoomUseCaseFactory {
    private HostWaitRoomUseCaseFactory(){}
    public static HostWaitRoomView create(WaitRoomViewModel waitRoomViewModel){
        return new HostWaitRoomView(waitRoomViewModel);
    }
}
