package app;

import interface_adapter.Scoreboard.ScoreboardViewModel;
import view.ScoreboardView;

public class ScoreboardViewBuilder {
    private ScoreboardViewBuilder(){

    }

    public static ScoreboardView createView(ScoreboardViewModel scoreboardViewModel) {
        return new ScoreboardView(scoreboardViewModel);
    }
}
