package use_case.AddMainPlayer;

public class AddMainPlayerInputData {
    private final String mainPlayerName;
    private final String lobbyID;
    private final boolean host;

    public AddMainPlayerInputData(String mainPlayerName, String lobbyID, boolean host) {
        this.mainPlayerName = mainPlayerName;
        this.lobbyID = lobbyID;
        this.host = host;
    }

    public String getMainPlayerName() {
        return mainPlayerName;
    }

    public boolean isHost() {
        return host;
    }

    public String getLobbyID() {
        return lobbyID;
    }
}
