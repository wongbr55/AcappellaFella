package use_case.EnterWaitRoom.JoinEnterWaitRoom;

public class JoinEnterWaitRoomInputData {
    private final String lobbyID;

    public JoinEnterWaitRoomInputData(String lobbyID) {
        this.lobbyID = lobbyID;
    }

    public String getLobbyID() {
        return lobbyID;
    }
}
