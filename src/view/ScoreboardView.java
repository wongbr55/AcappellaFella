package view;

import entity.Player;
import interface_adapter.UpdateScore.UpdateScoreState;
import interface_adapter.UpdateScore.UpdateScoreViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;

public class ScoreboardView extends JPanel implements ActionListener, PropertyChangeListener {
    private final UpdateScoreViewModel updateScoreViewModel;
    public final String viewName = "scoreboard";

    public ScoreboardView(UpdateScoreViewModel updateScoreViewModel){
        this.updateScoreViewModel = updateScoreViewModel;
        this.updateScoreViewModel.addPropertyChangeListener(this);

        UpdateScoreState state = this.updateScoreViewModel.getState();
        Map<Player, Integer> scoreboard = state.getScoreboard();


        for (Map.Entry<Player, Integer> entry: scoreboard.entrySet()){
            String username = entry.getKey().getName();
            Integer score = entry.getValue();
            JLabel label = new JLabel(username + ": " + score);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(label);
        }

        this.setBorder(BorderFactory.createEmptyBorder());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}