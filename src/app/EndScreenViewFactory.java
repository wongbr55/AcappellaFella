package app;

import interface_adapter.EndScreen.EndScreenViewModel;
import view.EndScreenView;

public class EndScreenViewFactory {


    public EndScreenViewFactory(){}

    public static EndScreenView createView(EndScreenViewModel endScreenViewModel){
        return new EndScreenView(endScreenViewModel);
    }
}
