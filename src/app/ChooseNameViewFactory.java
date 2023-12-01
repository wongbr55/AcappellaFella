package app;

import interface_adapter.ChooseName.ChooseNameViewModel;
import interface_adapter.ChooseName.HostChooseNameViewModel;
import interface_adapter.ChooseName.JoinChooseNameViewModel;
import view.ChooseNameView;
import view.HostChooseNameView;
import view.JoinChooseNameView;

public class ChooseNameViewFactory {
    private ChooseNameViewFactory(){}

    public static JoinChooseNameView createJoinView(JoinChooseNameViewModel startLobbyViewModel){
        return new JoinChooseNameView(startLobbyViewModel);
    }

    public static HostChooseNameView createHostView(HostChooseNameViewModel startLobbyViewModel){
        return new HostChooseNameView(startLobbyViewModel);
    }
}
