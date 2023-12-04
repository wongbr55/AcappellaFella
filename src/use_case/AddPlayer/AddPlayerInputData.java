package use_case.AddPlayer;

public class AddPlayerInputData {

    private final String playerName;

    public AddPlayerInputData(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }
}
