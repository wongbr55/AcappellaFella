package view;

import interface_adapter.AddMainPlayer.AddMainPlayerController;
import interface_adapter.ChooseName.ChooseNameState;
import interface_adapter.ChooseName.ChooseNameViewModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JoinChooseNameView extends ChooseNameView {
    public final String viewName = "join choose name";
    private final AddMainPlayerController addMainPlayerController;

    public JoinChooseNameView(ChooseNameViewModel chooseNameViewModel, AddMainPlayerController addMainPlayerController) {
        super(chooseNameViewModel);
        this.addMainPlayerController = addMainPlayerController;

        this.createLobby.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(createLobby)) {
                    ChooseNameState currentState = chooseNameViewModel.getState();
                    addMainPlayerController.execute(currentState.getName(), currentState.getLobbyID(), false);
                }
            }
        });
    }
}
