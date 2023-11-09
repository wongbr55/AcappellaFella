package view;

import interface_adapter.CheckGuess.CheckGuessState;
import interface_adapter.CheckGuess.CheckGuessViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PlayerGuessView extends JPanel implements ActionListener, PropertyChangeListener {
    private final JLabel title;
    public String viewName = "player guess";
    public CheckGuessViewModel checkGuessViewModel;

    public PlayerGuessView(ChatView chatView, CheckGuessViewModel checkGuessViewModel) {
        this.checkGuessViewModel = checkGuessViewModel;
        checkGuessViewModel.addPropertyChangeListener(this);
        CheckGuessState checkGuessState = checkGuessViewModel.getState();

        this.title = new JLabel(checkGuessState.getTitleLabel());
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
        this.title.setText(checkGuessViewModel.getState().getTitleLabel());
    }
}
