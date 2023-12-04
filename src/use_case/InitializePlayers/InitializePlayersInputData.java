package use_case.InitializePlayers;

import java.util.List;

public class InitializePlayersInputData {
    private final List<String> playerNames;

    public InitializePlayersInputData(List<String> playerNames) {
        this.playerNames = playerNames;
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }
}
