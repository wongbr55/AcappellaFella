package app;

import interface_adapter.RunGame.RunGameController;
import interface_adapter.WaitRoom.WaitRoomViewModel;
import view.JoinWaitRoomView;

public class JoinWaitRoomUseCaseFactory {
    private JoinWaitRoomUseCaseFactory(){}
    public static JoinWaitRoomView create(WaitRoomViewModel waitRoomViewModel){
        return new JoinWaitRoomView(waitRoomViewModel);
    }
}
