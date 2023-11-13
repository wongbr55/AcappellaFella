package app;

import interface_adapter.SingerSing.SingerSingViewModel;
import view.SingerSingView;

public class SingerSingUseCaseFactory {
    private SingerSingUseCaseFactory() {
    }

    public static SingerSingView create(SingerSingViewModel singerSingViewModel) {
        return new SingerSingView(singerSingViewModel);
    }

}
