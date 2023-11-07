package view;

import interface_adapter.PlayerGuess.PlayerGuessState;
import interface_adapter.PlayerGuess.PlayerGuessViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PlayerGuessView extends JPanel implements ActionListener, PropertyChangeListener {

    public String viewName = "player guess";
    public PlayerGuessViewModel playerGuessViewModel;
    private final JLabel title;

    public PlayerGuessView(ChatView chatView, PlayerGuessViewModel playerGuessViewModel) {
        this.playerGuessViewModel = playerGuessViewModel;
        playerGuessViewModel.addPropertyChangeListener(this);
        PlayerGuessState playerGuessState = playerGuessViewModel.getState();

        this.title = new JLabel(playerGuessState.getTitleLabel());
        this.title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(this.title);
        this.add(chatView);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // set the text to be either yah or nah based off of guess
        // Must call from presenter however
        this.title.setText(playerGuessViewModel.getState().getTitleLabel());
    }
}
