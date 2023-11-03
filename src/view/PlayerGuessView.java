package view;

import interface_adapter.PlayerGuess.PlayerGuessController;
import interface_adapter.PlayerGuess.PlayerGuessViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PlayerGuessView  extends JPanel implements ActionListener, PropertyChangeListener {

    public String viewName = "player guess";
    public PlayerGuessViewModel playerGuessViewModel;
    private PlayerGuessController playerGuessController;
    private ChatView chatView;

    public PlayerGuessView(ChatView chatView) {
        this.chatView = chatView;

//        playerGuessViewModel.addPropertyChangeListener(this);
//
//

        JLabel title = new JLabel("Guess!");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panel = new JPanel();
        panel.add(title);
        panel.add(this.chatView);
        panel.setLayout(new GridLayout(0, 1));

//
//        LabelTextPanel guessInfo = new LabelTextPanel(
//                new JLabel(PlayerGuessViewModel.GUESS_LABEL), guessInputField);
//
//        JPanel buttons = new JPanel();
//        PlayerGuessState state = playerGuessViewModel.getState();
//        checkGuess = new JButton(state.getcheckGuess).toString());
//        buttons.add(checkGuess);
//
//
//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//        this.add(title);
//        this.add(buttons);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
