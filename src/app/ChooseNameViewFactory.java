package app;

import interface_adapter.ChooseName.HostChooseName.HostChooseNameViewModel;
import interface_adapter.ChooseName.JoinChooseName.JoinChooseNameViewModel;
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
