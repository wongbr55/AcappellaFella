package interface_adapter.Scoreboard;

import entity.Player;

import java.util.HashMap;
import java.util.Map;

public class ScoreboardState {

    private final Map<Player, Integer> scoreboard = new HashMap<>();

    public ScoreboardState() {
    }
    public Map<Player, Integer> getScoreboard() {
        return this.scoreboard;
    }
    public void addPlayer(Player player){
        scoreboard.put(player, 0);
    }
}
