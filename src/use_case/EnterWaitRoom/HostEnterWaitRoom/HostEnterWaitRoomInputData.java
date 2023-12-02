package use_case.EnterWaitRoom.HostEnterWaitRoom;

public class HostEnterWaitRoomInputData {
    private final String lobbyID;

    public HostEnterWaitRoomInputData(String lobbyID) {
        this.lobbyID = lobbyID;
    }

    public String getLobbyID() {
        return lobbyID;
    }
}
