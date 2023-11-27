package view;

import interface_adapter.EndScreen.EndScreenViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EndScreenView extends JPanel implements ActionListener, PropertyChangeListener {

    private JLabel firstPlayerName;

    private JButton playAgain;
    private JButton toMenu;

    public EndScreenView(EndScreenViewModel endScreenViewModel){
        endScreenViewModel.addPropertyChangeListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
