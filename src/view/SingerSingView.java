package view;

import interface_adapter.SingerSing.SingerSingViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SingerSingView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "singer sing";
    public final SingerSingViewModel singerSingViewModel;
    public final JLabel song;

    public SingerSingView(ScoreboardView scoreboardView, SingerSingViewModel singerSingViewModel) {

        this.singerSingViewModel = singerSingViewModel;
        this.singerSingViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(this.singerSingViewModel.getTitleLabel());
        song = new JLabel(this.singerSingViewModel.getState().getSongLabel());
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setAlignmentY(Component.CENTER_ALIGNMENT);
        song.setAlignmentX(Component.CENTER_ALIGNMENT);
        song.setAlignmentY(Component.CENTER_ALIGNMENT);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(song);
        this.add(scoreboardView);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.song.setText(singerSingViewModel.getState().getSongLabel());
    }
}
