package use_case.EnterWaitRoom.JoinEnterWaitRoom;

public class JoinEnterWaitRoomInputData {
    private final String lobbyID;
    private final String nameError;

    public JoinEnterWaitRoomInputData(String lobbyID, String nameError) {
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
