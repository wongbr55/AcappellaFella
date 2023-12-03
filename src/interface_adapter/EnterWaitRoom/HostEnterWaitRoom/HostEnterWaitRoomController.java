package interface_adapter.EnterWaitRoom.HostEnterWaitRoom;

import use_case.EnterWaitRoom.HostEnterWaitRoom.HostEnterWaitRoomInputBoundary;
import use_case.EnterWaitRoom.HostEnterWaitRoom.HostEnterWaitRoomInputData;

public class HostEnterWaitRoomController {
    final HostEnterWaitRoomInputBoundary hostEnterWaitRoomInteractor;

    public HostEnterWaitRoomController(HostEnterWaitRoomInputBoundary hostEnterWaitRoomInteractor) {
        this.hostEnterWaitRoomInteractor = hostEnterWaitRoomInteractor;
    }

    public void execute(String lobbyID, String nameError) {
        HostEnterWaitRoomInputData inputData = new HostEnterWaitRoomInputData(lobbyID, nameError);
        hostEnterWaitRoomInteractor.execute(inputData);
    }
}
