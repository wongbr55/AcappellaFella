package view;

import interface_adapter.WaitRoom.WaitRoomState;
import interface_adapter.WaitRoom.WaitRoomViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class JoinWaitRoomView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "join wait room";
    private final WaitRoomViewModel waitRoomViewModel;
    private final JLabel lobbyID;

    public JoinWaitRoomView(WaitRoomViewModel waitRoomViewModel) {
        this.waitRoomViewModel = waitRoomViewModel;
        this.waitRoomViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Waiting for host to start");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        lobbyID = new JLabel("Lobby ID:");

        this.add(title);
        this.add(lobbyID);
    }

    public void actionPerformed(ActionEvent evt) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof WaitRoomState state) {
            lobbyID.setText("Lobby ID: " + state.getLobbyID());
        }
    }
}

