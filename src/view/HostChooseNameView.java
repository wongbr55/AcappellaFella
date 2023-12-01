package view;

import interface_adapter.ChooseName.ChooseNameState;
import interface_adapter.ChooseName.ChooseNameViewModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HostChooseNameView extends ChooseNameView {
    public HostChooseNameView(ChooseNameViewModel chooseNameViewModel) {
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
