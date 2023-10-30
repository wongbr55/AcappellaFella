package view;

import interface_adapter.PlayerGuess.PlayerGuessController;
import interface_adapter.PlayerGuess.PlayerGuessState;
import interface_adapter.PlayerGuess.PlayerGuessViewModel;
import interface_adapter.PlayerGuess.PlayerGuessController;
import interface_adapter.PlayerGuess.PlayerGuessState;
import interface_adapter.PlayerGuess.PlayerGuessViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PlayerGuessView  extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "player guess";
    public final PlayerGuessViewModel playerGuessViewModel;
    private final PlayerGuessController playerGuessController;

    private final JTextField guessInputField = new JTextField(15);

    private final JButton checkGuess;

    public PlayerGuessView(PlayerGuessViewModel playerGuessViewModel, PlayerGuessController playerGuessController) {
        this.playerGuessViewModel = playerGuessViewModel;
        this.playerGuessController = playerGuessController;
        playerGuessViewModel.addPropertyChangeListener(this);


        JLabel title = new JLabel(PlayerGuessViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel guessInfo = new LabelTextPanel(
                new JLabel(PlayerGuessViewModel.GUESS_LABEL), guessInputField);

        JPanel buttons = new JPanel();
        PlayerGuessState state = playerGuessViewModel.getState();
        checkGuess = new JButton(state.getcheckGuess).toString());
        buttons.add(checkGuess);


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
