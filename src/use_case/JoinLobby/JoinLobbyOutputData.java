package use_case.JoinLobby;

public class JoinLobbyOutputData {
    final private String lobbyID;

    public JoinLobbyOutputData(String lobbyID) {
        this.lobbyID = lobbyID;
    }

    public String getLobbyID() {
        return lobbyID;
    }
}
