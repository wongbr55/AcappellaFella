package data_access;

import entity.Scoreboard;
import use_case.UpdateScore.UpdateScoreDataAccessInterface;

public class InMemoryScoreboardDataAccessObject implements UpdateScoreDataAccessInterface {

    private final Scoreboard scoreboard = new Scoreboard();
    @Override
    public Scoreboard getScoreboard() {
        return scoreboard;
    }
}
