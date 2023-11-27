package view;

import interface_adapter.StartLobby.StartLobbyState;
import interface_adapter.StartLobby.StartLobbyViewModel;
import interface_adapter.StartLobby.StartLobbyController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class StartLobbyView extends JPanel implements ActionListener, PropertyChangeListener {
    public static final String viewName = "create lobby";
    private final StartLobbyViewModel startLobbyViewModel;
    private final JTextField nameInputField = new JTextField(15);
    private final StartLobbyController startLobbyController;
    private final JButton lobbyStart;

    public StartLobbyView(StartLobbyViewModel startLobbyViewModel, StartLobbyController controller) {

        this.startLobbyController = controller;
        this.startLobbyViewModel = startLobbyViewModel;
        this.startLobbyViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel nameInfo = new LabelTextPanel(
                new JLabel("Enter Name"), nameInputField);
        JPanel buttons = new JPanel();
        lobbyStart = new JButton(StartLobbyViewModel.START_BUTTON_LABEL);
        buttons.add(lobbyStart);
        lobbyStart.addActionListener(                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(lobbyStart)) {
                            StartLobbyState currentState = startLobbyViewModel.getState();
                            controller.execute(
                                    currentState.getname()
                            );
                        }
                    }
                }
        );
        nameInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                StartLobbyState currentState = startLobbyViewModel.getState();
                currentState.setname(nameInputField.getText() + e.getKeyChar());
                startLobbyViewModel.setState(currentState);
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
        this.add(nameInfo);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}