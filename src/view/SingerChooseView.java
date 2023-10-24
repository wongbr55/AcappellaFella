package view;

import interface_adapter.SingerChoose.SingerChooseController;
import interface_adapter.SingerChoose.SingerChooseViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SingerChooseView  extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "singer choose";
    public final SingerChooseViewModel singerChooseViewModel;
    private final SingerChooseController singerChooseController;

    public SingerChooseView(SingerChooseViewModel singerChooseViewModel, SingerChooseController singerChooseController) {
        this.singerChooseViewModel = singerChooseViewModel;
        this.singerChooseController = singerChooseController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
