package view;

import interface_adapter.SingerChoose.SingerChooseController;
import interface_adapter.SingerChoose.SingerChooseState;
import interface_adapter.SingerChoose.SingerChooseViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SingerChooseView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "singer choose";
    public final SingerChooseViewModel singerChooseViewModel;
    private final SingerChooseController singerChooseController;

    private final JButton song1;
    private final JButton song2;
    private final JButton song3;

    public SingerChooseView(SingerChooseViewModel singerChooseViewModel, SingerChooseController singerChooseController) {
        this.singerChooseViewModel = singerChooseViewModel;
        this.singerChooseController = singerChooseController;
        this.singerChooseViewModel.addPropertyChangeListener(this);


        JLabel title = new JLabel(SingerChooseViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        SingerChooseState state = singerChooseViewModel.getState();
        song1 = new JButton(state.getSong1Name());
        buttons.add(song1);
        song2 = new JButton(state.getSong2Name());
        buttons.add(song2);
        song3 = new JButton(state.getSong3Name());
        buttons.add(song3);

        song1.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(song1)) {
                            SingerChooseState currentState = singerChooseViewModel.getState();

                            singerChooseController.execute(currentState.getSong1Name());
                        }
                    }
                }
        );
        song2.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(song2)) {
                            SingerChooseState currentState = singerChooseViewModel.getState();

                            singerChooseController.execute(currentState.getSong2Name());
                        }
                    }
                }
        );
        song3.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(song3)) {
                            SingerChooseState currentState = singerChooseViewModel.getState();

                            singerChooseController.execute(currentState.getSong3Name());
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SingerChooseState state = singerChooseViewModel.getState();
        song1.setText(state.getSong1Name());
        song2.setText(state.getSong2Name());
        song3.setText(state.getSong3Name());
    }
}
