package view;

import interface_adapter.ChooseName.ChooseNameState;
import interface_adapter.ChooseName.ChooseNameViewModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JoinChooseNameView extends ChooseNameView {
    public final String viewName = "join choose name";
    public JoinChooseNameView(ChooseNameViewModel chooseNameViewModel) {
        super(chooseNameViewModel);

        this.createLobby.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(createLobby)) {
                            ChooseNameState currentState = chooseNameViewModel.getState();
                            // todo call something here
                        }
                    }
                });
    }
}
