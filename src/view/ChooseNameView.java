package view;

import interface_adapter.ChooseName.ChooseNameState;
import interface_adapter.ChooseName.ChooseNameViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public abstract class ChooseNameView extends JPanel implements ActionListener, PropertyChangeListener {
    public static final String viewName = "create lobby";
    private final ChooseNameViewModel chooseNameViewModel;
    private final JTextField nameInputField = new JTextField(15);
    final JButton createLobby;

    public ChooseNameView(ChooseNameViewModel chooseNameViewModel) {
        this.chooseNameViewModel = chooseNameViewModel;
        this.chooseNameViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(ChooseNameViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel nameInput = new LabelTextPanel(new JLabel("Enter Name"), nameInputField);

        JPanel buttons = new JPanel();
        this.createLobby = new JButton(chooseNameViewModel.JOIN_LOBBY_LABEL);
        buttons.add(createLobby);
        nameInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                ChooseNameState currentState = chooseNameViewModel.getState();
                currentState.setName(nameInputField.getText() + e.getKeyChar());
                chooseNameViewModel.setState(currentState);
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
        this.add(nameInput);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}