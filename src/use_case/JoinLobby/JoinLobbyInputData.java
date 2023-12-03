package use_case.JoinLobby;

public class JoinLobbyInputData {
    final private String lobbyID;

    public JoinLobbyInputData(String lobbyID) {
        this.lobbyID = lobbyID;
    }

    public String getLobbyID() {
        return lobbyID;
    }
}
