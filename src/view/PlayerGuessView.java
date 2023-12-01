package view;

import interface_adapter.PlayerGuess.PlayerGuessState;
import interface_adapter.PlayerGuess.PlayerGuessViewModel;
import interface_adapter.SingerSing.SingerSingState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PlayerGuessView extends JPanel implements ActionListener, PropertyChangeListener {
    public String viewName = "player guess";
    public PlayerGuessViewModel playerGuessViewModel;
    private final JLabel timer;

    public PlayerGuessView(ScoreboardView scoreboardView, ChatView chatView, PlayerGuessViewModel playerGuessViewModel) {
        this.playerGuessViewModel = playerGuessViewModel;
        playerGuessViewModel.addPropertyChangeListener(this);
        PlayerGuessState playerGuessState = playerGuessViewModel.getState();

        JLabel title = new JLabel(playerGuessState.getTitleLabel());
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.timer = new JLabel("0");

        this.add(title);
        this.add(timer);
        this.add(chatView);
        this.add(scoreboardView);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        PlayerGuessState state = (PlayerGuessState) evt.getNewValue();
        timer.setText(state.getTime());
    }
}
