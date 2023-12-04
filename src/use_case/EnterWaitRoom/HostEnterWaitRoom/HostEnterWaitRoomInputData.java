package use_case.EnterWaitRoom.HostEnterWaitRoom;

public class HostEnterWaitRoomInputData {
    private final String lobbyID;
    private final String nameError;

    public HostEnterWaitRoomInputData(String lobbyID, String nameError) {
        this.lobbyID = lobbyID;
        this.nameError = nameError;
    }

    public String getLobbyID() {
        return lobbyID;
    }

    public String getNameError() {
        return nameError;
    }
}
