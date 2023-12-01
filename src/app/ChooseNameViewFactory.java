package app;

import interface_adapter.ChooseName.ChooseNameViewModel;
import view.ChooseNameView;

public class ChooseNameViewFactory {
    private ChooseNameViewFactory(){}

    public static ChooseNameView create(ChooseNameViewModel startLobbyViewModel){
        return new ChooseNameView(startLobbyViewModel);

    }
}
