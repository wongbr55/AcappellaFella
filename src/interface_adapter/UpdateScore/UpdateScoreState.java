package interface_adapter.UpdateScore;

import entity.Player;

import java.util.HashMap;
import java.util.Map;

public class UpdateScoreState {

    private final Map<Player, Integer> scoreboard = new HashMap<>();

    public UpdateScoreState() {
    }
    public Map<Player, Integer> getScoreboard() {
        return this.scoreboard;
    }
    public void addPlayer(Player player){
        scoreboard.put(player, 0);
    }
}
