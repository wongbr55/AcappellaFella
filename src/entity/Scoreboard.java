package entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Scoreboard {

    private final Map<Player, Integer> scoreboard = new HashMap<>();

    public Scoreboard(){}

    public void addPlayer(Player player){
        this.scoreboard.put(player, 0);
    }
    public Integer getPlayerScore(Player player){
        return this.scoreboard.getOrDefault(player, -1);
    }
    public void updatePlayerScore(Player player, Integer addScore){
        if (this.scoreboard.containsKey(player)){
            Integer prevScore = this.scoreboard.get(player);
            this.scoreboard.put(player, prevScore + addScore);
        }
        else{
            System.out.println("No player found");
        }
    }

    public Integer getNumberOfPlayers(){
        return scoreboard.size();
    }

    public String getFirstPlaceName(){
        return Collections.max(scoreboard.entrySet(), Map.Entry.comparingByValue()).getKey().getName();
    }

    public Integer getFirstPlaceScore(){
        return Collections.max(scoreboard.entrySet(), Map.Entry.comparingByValue()).getValue();
    }
}
