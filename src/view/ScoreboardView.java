package view;

import interface_adapter.Scoreboard.ScoreboardState;
import interface_adapter.Scoreboard.ScoreboardViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;

public class ScoreboardView extends JPanel implements ActionListener, PropertyChangeListener {
    private final ScoreboardViewModel scoreboardViewModel;
    public final String viewName = "scoreboard";
    private JLabel scores = new JLabel();

    public ScoreboardView(ScoreboardViewModel scoreboardViewModel){
        this.scoreboardViewModel = scoreboardViewModel;
        this.scoreboardViewModel.addPropertyChangeListener(this);

        String scoresSoFar = "<html>";
        for (Map.Entry<String, Integer> entry: this.scoreboardViewModel.getState().getScoreboard().entrySet()){
            String username = entry.getKey();
            Integer score = entry.getValue();
            scoresSoFar += username + ": " + score + "<br>";
//            JLabel label = new JLabel(username + ": " + score);
//            label.setAlignmentX(Component.CENTER_ALIGNMENT);
//            this.panel.add(label);
        }
        scoresSoFar += "</html>";
        this.scores.setText(scoresSoFar);
        this.add(scores);


        this.setBorder(BorderFactory.createEmptyBorder());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Got into the view");
        String scoresSoFar = "<html>";
        for (Map.Entry<String, Integer> entry: this.scoreboardViewModel.getState().getScoreboard().entrySet()){
            String username = entry.getKey();
            Integer score = entry.getValue();
            scoresSoFar += username + ": " + score + "<br>";
//            JLabel label = new JLabel(username + ": " + score);
//            label.setAlignmentX(Component.CENTER_ALIGNMENT);
//            this.panel.add(label);
        }
        scoresSoFar += "</html>";
        this.scores.setText(scoresSoFar);

    }
}
