package view;


import interface_adapter.SingerChoose.SingerChooseViewModel;
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

    public SingerSingView(ScoreboardView scoreboardView, SingerSingViewModel singerSingViewModel) {
        this.singerSingViewModel = singerSingViewModel;
        JLabel title = new JLabel(SingerSingViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setAlignmentY(Component.CENTER_ALIGNMENT);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        // add scoreboardView
        this.add(scoreboardView);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
