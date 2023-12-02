package view;

import interface_adapter.ChooseName.ChooseNameState;
import interface_adapter.ChooseName.ChooseNameViewModel;
import interface_adapter.EnterWaitRoom.HostEnterWaitRoom.HostEnterWaitRoomController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HostChooseNameView extends ChooseNameView {
    public final String viewName = "host choose name";
    private final HostEnterWaitRoomController hostEnterWaitRoomController;
    public HostChooseNameView(ChooseNameViewModel chooseNameViewModel, HostEnterWaitRoomController hostEnterWaitRoomController) {
        super(chooseNameViewModel);
        this.hostEnterWaitRoomController = hostEnterWaitRoomController;

        this.createLobby.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(createLobby)) {
                            ChooseNameState currentState = chooseNameViewModel.getState();
                            hostEnterWaitRoomController.execute(currentState.getLobbyID());
                        }
                    }
                });
    }
}
