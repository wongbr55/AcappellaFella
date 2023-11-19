package app;

import interface_adapter.UpdateScore.UpdateScoreViewModel;
import view.ScoreboardView;

public class ScoreboardViewBuilder {
    private ScoreboardViewBuilder(){

    }

    public static ScoreboardView createView(UpdateScoreViewModel updateScoreViewModel) {
        return new ScoreboardView(updateScoreViewModel);
    }
}
