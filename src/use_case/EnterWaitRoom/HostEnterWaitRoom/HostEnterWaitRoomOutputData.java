package use_case.EnterWaitRoom.HostEnterWaitRoom;

public class HostEnterWaitRoomOutputData {
    private final String lobbyID;

    public HostEnterWaitRoomOutputData(String lobbyID) {
        this.lobbyID = lobbyID;
    }

    public String getLobbyID() {
        return lobbyID;
    }
}
