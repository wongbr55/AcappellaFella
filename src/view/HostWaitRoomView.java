package view;

import interface_adapter.StartGame.StartGameController;
import interface_adapter.WaitRoom.WaitRoomState;
import interface_adapter.WaitRoom.WaitRoomViewModel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HostWaitRoomView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "host wait room";
    private final WaitRoomViewModel waitRoomViewModel;
    private final JLabel lobbyID;
    private final JTextField playlistInputField = new JTextField(15);
    private final JSlider numberOfRoundsSlider;
    private final JSlider roundLengthSlider;
    private final JButton startGame;
    private final JButton loadPlaylist;
    private final StartGameController startGameController;

    public HostWaitRoomView(WaitRoomViewModel waitRoomViewModel, StartGameController startGameController) {
        this.waitRoomViewModel = waitRoomViewModel;
        this.waitRoomViewModel.addPropertyChangeListener(this);

        this.startGameController = startGameController;

        lobbyID = new JLabel("Lobby ID:");

        LabelTextPanel playlistInfo = new LabelTextPanel(new JLabel("Spotify playlist link"), playlistInputField);

        JLabel numberOfRoundsDesc = new JLabel("Set the number of rounds");
        JLabel roundLengthDesc = new JLabel("Set the length of each round");

        numberOfRoundsSlider = new JSlider(JSlider.HORIZONTAL, 1, 5, 3);
        numberOfRoundsSlider.setMajorTickSpacing(1);
        numberOfRoundsSlider.setMinorTickSpacing(1);
        numberOfRoundsSlider.setPaintTicks(true);
        numberOfRoundsSlider.setPaintLabels(true);
        numberOfRoundsSlider.setSnapToTicks(true);
        numberOfRoundsSlider.setLabelTable(numberOfRoundsSlider.createStandardLabels(5));

        roundLengthSlider = new JSlider(JSlider.HORIZONTAL, 15, 120, 60);
        roundLengthSlider.setMajorTickSpacing(15);
        roundLengthSlider.setPaintTicks(true);
        roundLengthSlider.setPaintLabels(true);
        roundLengthSlider.setSnapToTicks(true);
        roundLengthSlider.setLabelTable(roundLengthSlider.createStandardLabels(15));

        startGame = new JButton(WaitRoomViewModel.START_GAME_BUTTON_LABEL);

        loadPlaylist = new JButton(WaitRoomViewModel.LOAD_PLAYLIST_BUTTON_LABEL);

        startGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(startGame)) {
                    WaitRoomState currentState = waitRoomViewModel.getState();

                    startGameController.execute(currentState.getNumberOfRounds(), currentState.getRoundLength());
                }
            }
        });

        loadPlaylist.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(loadPlaylist)) {
                    WaitRoomState currentState = waitRoomViewModel.getState();
                    currentState.setPlaylistLink(playlistInputField.getText());
                    waitRoomViewModel.setState(currentState);

                    // todo add load playlist controller
                }
            }
        });

        numberOfRoundsSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (!numberOfRoundsSlider.getValueIsAdjusting()) {
                    WaitRoomState currentState = waitRoomViewModel.getState();
                    currentState.setNumberOfRounds(numberOfRoundsSlider.getValue());
                    waitRoomViewModel.setState(currentState);
                }
            }
        });

        roundLengthSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (!roundLengthSlider.getValueIsAdjusting()) {
                    WaitRoomState currentState = waitRoomViewModel.getState();
                    currentState.setRoundLength(roundLengthSlider.getValue());
                    waitRoomViewModel.setState(currentState);
                }
            }
        });


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel playListLoadMenu = new JPanel();
        playListLoadMenu.add(playlistInfo);
        playListLoadMenu.add(loadPlaylist);
        this.add(lobbyID);
        this.add(playListLoadMenu);
        this.add(numberOfRoundsDesc);
        this.add(numberOfRoundsSlider);
        this.add(roundLengthDesc);
        this.add(roundLengthSlider);
        this.add(startGame);
    }

    public void actionPerformed(ActionEvent evt) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof WaitRoomState state) {
            lobbyID.setText("Lobby ID: " + state.getLobbyID());
        }
    }
}