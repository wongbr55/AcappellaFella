package view;

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

    public JoinWaitRoomView(WaitRoomViewModel waitRoomViewModel) {
        this.waitRoomViewModel = waitRoomViewModel;
        this.waitRoomViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Waiting for host to start");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(title);
    }

    public void actionPerformed(ActionEvent evt) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}

