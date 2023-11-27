package view;

import interface_adapter.RunGame.RunGameController;
import interface_adapter.WaitRoom.WaitRoomState;
import interface_adapter.WaitRoom.WaitRoomViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HostWaitRoomView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Waiting for Players";
    private final WaitRoomViewModel waitRoomViewModel;
    private final RunGameController runGameController;

    JLabel player;

    private final JTextField roundInputField = new JTextField(15);
    private final JTextField lengthRoundInputField = new JTextField(15);
    private final JTextField playlistNameInputField = new JTextField(15);

    final JButton startLobby;

    public HostWaitRoomView(WaitRoomViewModel waitRoomViewModel, RunGameController runGameController) {
        this.waitRoomViewModel = waitRoomViewModel;
        this.runGameController = runGameController;
        this.waitRoomViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Waiting for Players");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel usernameInfo = new JLabel("Currently logged in: ");
        player = new JLabel();

        LabelTextPanel roundInfo = new LabelTextPanel(
                new JLabel("Enter Number of Rounds"), roundInputField);
        LabelTextPanel lengthRoundInfo = new LabelTextPanel(
                new JLabel("Enter Length of Round"), lengthRoundInputField);
        LabelTextPanel playlistNameInfo = new LabelTextPanel(
                new JLabel("Enter Name of Playlist"), playlistNameInputField);

        JPanel buttons = new JPanel();
        startLobby = new JButton(WaitRoomViewModel.STARTLOBBY_BUTTON_LABEL);
        buttons.add(startLobby);

        startLobby.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(startLobby)) {
                            WaitRoomState currentState = waitRoomViewModel.getState();

                            // todo add rungamecontroller
                            // runGameController.execute();
                        }
                    }
                }
        );
        roundInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                WaitRoomState currentState = waitRoomViewModel.getState();
                currentState.setround(roundInputField.getText() + e.getKeyChar());
                waitRoomViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        lengthRoundInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                WaitRoomState currentState = waitRoomViewModel.getState();
                currentState.setround(lengthRoundInputField.getText() + e.getKeyChar());
                waitRoomViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        playlistNameInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                WaitRoomState currentState = waitRoomViewModel.getState();
                currentState.setround(playlistNameInputField.getText() + e.getKeyChar());
                waitRoomViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(roundInfo);
        this.add(lengthRoundInfo);
        this.add(playlistNameInfo);
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