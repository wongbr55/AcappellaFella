package app;

import interface_adapter.RunGame.RunGameController;
import interface_adapter.WaitRoom.WaitRoomViewModel;
import view.HostWaitRoomView;

public class HostWaitRoomUseCaseFactory {
    private HostWaitRoomUseCaseFactory(){}
    public static HostWaitRoomView create(WaitRoomViewModel waitRoomViewModel){
        RunGameController controller = createRunGameUseCase();
        return new HostWaitRoomView(waitRoomViewModel, controller);
    }
    private static RunGameController createRunGameUseCase(){return new RunGameController();}

}
