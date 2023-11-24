package view;

import interface_adapter.JoinLobby.JoinLobbyController;
import interface_adapter.JoinLobby.JoinLobbyState;
import interface_adapter.JoinLobby.JoinLobbyViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class JoinLobbyView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "join lobby";
    private final JoinLobbyViewModel joinLobbyViewModel;
    private final JTextField nameInputField = new JTextField(15);
    private final JoinLobbyController joinLobbyController;
    private final JButton lobbyJoin;

    public JoinLobbyView(JoinLobbyViewModel joinLobbyViewModel, JoinLobbyController controller) {

        this.joinLobbyController = controller;
        this.joinLobbyViewModel = joinLobbyViewModel;
        this.joinLobbyViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel nameInfo = new LabelTextPanel(
                new JLabel("Enter Name"), nameInputField);
        JPanel buttons = new JPanel();
        lobbyJoin = new JButton(joinLobbyViewModel.JOIN_BUTTON_LABEL);
        buttons.add(lobbyJoin);
        lobbyJoin.addActionListener(                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(lobbyJoin)) {
                            JoinLobbyState currentState = joinLobbyViewModel.getState();
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
                JoinLobbyState currentState = joinLobbyViewModel.getState();
                currentState.setname(nameInputField.getText() + e.getKeyChar());
                joinLobbyViewModel.setState(currentState);
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
