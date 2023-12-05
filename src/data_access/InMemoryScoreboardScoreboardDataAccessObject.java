package data_access;

import entity.Player;
import entity.Scoreboard;
import use_case.AddMainPlayer.AddMainPlayerPlayerDataAccessInterface;
import use_case.AddMainPlayer.AddMainPlayerScoreboardDataAccessInterface;
import use_case.AddPlayer.AddPlayerScoreboardDataAccessInterface;
import use_case.RunGame.RunGameScoreboardDataAccessInterface;
import use_case.UpdateScore.UpdateScoreScoreboardDataAccessInterface;

public class InMemoryScoreboardScoreboardDataAccessObject implements UpdateScoreScoreboardDataAccessInterface, AddPlayerScoreboardDataAccessInterface, AddMainPlayerScoreboardDataAccessInterface, RunGameScoreboardDataAccessInterface {

    private final Scoreboard scoreboard = new Scoreboard();
    @Override
    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    public void addPlayer(Player player){
        this.scoreboard.addPlayer(player);
    }

    @Override
    public String getFirstPlaceName() {
        return this.scoreboard.getFirstPlaceName();
    }

    @Override
    public Integer getFirstPlaceScore() {
        return this.scoreboard.getFirstPlaceScore();
    }
}
