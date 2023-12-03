package view;

import interface_adapter.Home.HomeViewModel;
import interface_adapter.Home.HomeViewState;
import interface_adapter.JoinLobby.JoinLobbyController;
import interface_adapter.StartLobby.StartLobbyController;

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
    private final HomeViewModel homeViewModel;
    private final StartLobbyController startLobbyController;
    private final JoinLobbyController joinLobbyController;
    final JTextField idInputField = new JTextField(15);
    private final JButton create;
    private final JButton join;

    public HomeView(HomeViewModel homeViewModel, StartLobbyController startLobbyController, JoinLobbyController joinLobbyController) {
        this.homeViewModel = homeViewModel;
        this.startLobbyController = startLobbyController;
        this.joinLobbyController = joinLobbyController;
        homeViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(HomeViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel idInfo = new LabelTextPanel(new JLabel("Enter Game ID"), idInputField);

        create = new JButton(HomeViewModel.CREATE_BUTTON);
        create.setAlignmentX(Component.CENTER_ALIGNMENT);
        join = new JButton(HomeViewModel.JOIN_BUTTON);

        create.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(create)) {
                    startLobbyController.execute();

                    // view is switched in MessageLogger
                }
            }
        });

        join.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(join)) {
                    HomeViewState currentState = homeViewModel.getState();
                    joinLobbyController.execute(currentState.getLobbyID());
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

        JPanel joinMenu = new JPanel();
        joinMenu.add(idInfo);
        joinMenu.add(join);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);

        JPanel buttons = new JPanel();
        this.add(Box.createVerticalStrut(100));
        this.add(create);
        this.add(joinMenu);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
