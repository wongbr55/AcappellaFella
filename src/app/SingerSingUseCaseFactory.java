package app;

import interface_adapter.SingerSing.SingerSingViewModel;
import view.ScoreboardView;
import view.SingerSingView;

public class SingerSingUseCaseFactory {
    private SingerSingUseCaseFactory() {
    }

    public static SingerSingView create(SingerSingViewModel singerSingViewModel, ScoreboardView scoreboardView) {
        return new SingerSingView(scoreboardView, singerSingViewModel);
    }

}
