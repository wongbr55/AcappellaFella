package app;

import interface_adapter.Home.HomeViewModel;
import view.HomeView;

public class HomeUseCaseFactory {
    private HomeUseCaseFactory(){}

    public static HomeView create(HomeViewModel homeViewModel) {
        return new HomeView(homeViewModel);
    }
}
