package interface_adapter.Scoreboard;

import java.util.HashMap;
import java.util.Map;

public class ScoreboardState {

    private final Map<String, Integer> scoreboard = new HashMap<>();

    public ScoreboardState() {
    }
    public Map<String, Integer> getScoreboard() {
        return this.scoreboard;
    }
    public void addPlayer(String player){
        scoreboard.put(player, 0);
    }
}
