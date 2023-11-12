package view;

import interface_adapter.WaitRoom.WaitRoomController;
import interface_adapter.WaitRoom.WaitRoomState;
import interface_adapter.WaitRoom.WaitRoomViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class WaitRoomView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "Waiting for Players";
    private final WaitRoomViewModel waitRoomViewModel;
    private final WaitRoomController waitRoomController;

    JLabel player;

    final JButton startLobby;

    public WaitRoomView(WaitRoomViewModel waitRoomViewModel, WaitRoomController waitRoomController) {
        this.waitRoomViewModel = waitRoomViewModel;
        this.waitRoomController = waitRoomController;
        this.waitRoomViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Waiting for Players");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel usernameInfo = new JLabel("Currently logged in: ");
        player = new JLabel();

        JPanel buttons = new JPanel();
        startLobby = new JButton(WaitRoomViewModel.STARTLOBBY_BUTTON_LABEL);
        buttons.add(startLobby);

        startLobby.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(startLobby)) {
                            WaitRoomState currentState = waitRoomViewModel.getState();

                            waitRoomController.execute(currentState.startLobby());
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(player);
        this.add(buttons);
    }
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
