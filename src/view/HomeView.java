package view;

import interface_adapter.Home.HomeViewModel;
import interface_adapter.Home.HomeViewState;
import interface_adapter.JoinLobby.JoinLobbyController;
import interface_adapter.JoinLobby.JoinLobbyState;
import interface_adapter.JoinLobby.JoinLobbyViewModel;
import interface_adapter.StartLobby.StartLobbyController;
import interface_adapter.StartLobby.StartLobbyState;
import interface_adapter.StartLobby.StartLobbyViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HomeView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "home";
    final JTextField idInputField = new JTextField(15);
    private final HomeViewModel homeViewModel;
    private final JLabel idErrorField = new JLabel();

    private final JButton create;

    private final JButton join;

    public HomeView(HomeViewModel homeViewModel) {
        this.homeViewModel = homeViewModel;

        JLabel title = new JLabel(HomeViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel idInfo = new LabelTextPanel(new JLabel("Enter Game ID"), idInputField);

        JPanel buttons = new JPanel();
        create = new JButton(HomeViewModel.CREATE_BUTTON);
        buttons.add(create);
        join = new JButton(HomeViewModel.JOIN_BUTTON);
        buttons.add(join);

        create.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(create)) {
                    // todo call StartLobbyController
                }
            }
        });

        join.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(join)) {
                    // todo call JoinLobbyController
                }
            }
        });
        idInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                HomeViewState currentState = homeViewModel.getState();
                currentState.setLobbyID(idInputField.getText() + e.getKeyChar());
                homeViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(idInfo);
        this.add(idErrorField);
        this.add(buttons);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
