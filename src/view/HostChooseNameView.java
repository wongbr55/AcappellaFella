package view;

import interface_adapter.AddMainPlayer.AddMainPlayerController;
import interface_adapter.ChooseName.ChooseNameState;
import interface_adapter.ChooseName.ChooseNameViewModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HostChooseNameView extends ChooseNameView {
    public final String viewName = "host choose name";
    private final AddMainPlayerController addMainPlayerController;

    public HostChooseNameView(ChooseNameViewModel chooseNameViewModel, AddMainPlayerController addMainPlayerController) {
        super(chooseNameViewModel);
        this.addMainPlayerController = addMainPlayerController;

        this.createLobby.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(createLobby)) {
                    ChooseNameState currentState = chooseNameViewModel.getState();
                    addMainPlayerController.execute(currentState.getName(), currentState.getLobbyID(), true);
                }
            }
        });
    }
}
