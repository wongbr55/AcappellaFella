package use_case.EnterWaitRoom.JoinEnterWaitRoom;

public class JoinEnterWaitRoomOutputData {
    private final String lobbyID;

    public JoinEnterWaitRoomOutputData(String lobbyID) {
        this.lobbyID = lobbyID;
    }

    public String getLobbyID() {
        return lobbyID;
    }
}
