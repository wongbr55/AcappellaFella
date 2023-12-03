package use_case.AddMainPlayer;

public class AddMainPlayerOutputData {
    private final String playerName;

    public AddMainPlayerOutputData(String playerName, boolean host) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }
}
