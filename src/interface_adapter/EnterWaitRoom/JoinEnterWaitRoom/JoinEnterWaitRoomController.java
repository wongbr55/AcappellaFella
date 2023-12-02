package interface_adapter.EnterWaitRoom.JoinEnterWaitRoom;

import use_case.EnterWaitRoom.JoinEnterWaitRoom.JoinEnterWaitRoomInputBoundary;
import use_case.EnterWaitRoom.JoinEnterWaitRoom.JoinEnterWaitRoomInputData;

public class JoinEnterWaitRoomController {
    private final JoinEnterWaitRoomInputBoundary joinEnterWaitRoomInteractor;

    public JoinEnterWaitRoomController(JoinEnterWaitRoomInputBoundary joinEnterWaitRoomInteractor) {
        this.joinEnterWaitRoomInteractor = joinEnterWaitRoomInteractor;
    }

    public void execute(String lobbyID) {
        JoinEnterWaitRoomInputData inputData = new JoinEnterWaitRoomInputData(lobbyID);
        joinEnterWaitRoomInteractor.execute(inputData);
    }
}
