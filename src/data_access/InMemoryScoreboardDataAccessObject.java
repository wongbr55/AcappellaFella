package data_access;

import entity.Player;
import entity.Scoreboard;
import use_case.UpdateScore.UpdateScoreDataAccessInterface;

public class InMemoryScoreboardDataAccessObject implements UpdateScoreDataAccessInterface {

    private final Scoreboard scoreboard = new Scoreboard();
    @Override
    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    public void addPlayer(Player player){
        this.scoreboard.addPlayer(player);
    }
}
