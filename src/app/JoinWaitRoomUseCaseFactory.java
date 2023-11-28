package app;

import interface_adapter.RunGame.RunGameController;
import interface_adapter.WaitRoom.WaitRoomViewModel;
import view.JoinWaitRoomView;

public class JoinWaitRoomUseCaseFactory {
    private JoinWaitRoomUseCaseFactory(){}
    public static JoinWaitRoomView create(WaitRoomViewModel waitRoomViewModel){
        RunGameController controller = createRunGameUseCase();
        return new JoinWaitRoomView(waitRoomViewModel, controller);
    }
    private static RunGameController createRunGameUseCase(){return new RunGameController();}

}
