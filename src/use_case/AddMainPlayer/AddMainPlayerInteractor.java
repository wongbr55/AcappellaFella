package use_case.AddMainPlayer;

import entity.Message;
import entity.Player;
import interface_adapter.EnterWaitRoom.HostEnterWaitRoom.HostEnterWaitRoomController;
import interface_adapter.EnterWaitRoom.JoinEnterWaitRoom.JoinEnterWaitRoomController;
import interface_adapter.Scoreboard.ScoreboardState;
import interface_adapter.Scoreboard.ScoreboardViewModel;
import use_case.SendMessage.SendMessageInputBoundary;
import use_case.SendMessage.SendMessageInputData;

public class AddMainPlayerInteractor implements AddMainPlayerInputBoundary {

    private final AddMainPlayerPlayerDataAccessInterface playerDAO;
    private final AddMainPlayerScoreboardDataAccessInterface scoreboardDAO;
    private final AddMainPlayerGameStateDataAccessInterface gameStateDAO;
    private final ScoreboardViewModel scoreboardViewModel;
    private final SendMessageInputBoundary sendMessageInputBoundary;
    private final JoinEnterWaitRoomController joinEnterWaitRoomController;
    private final HostEnterWaitRoomController hostEnterWaitRoomController;
    private final AddMainPlayerOutputBoundary addMainPlayerPresenter;


    public AddMainPlayerInteractor(AddMainPlayerPlayerDataAccessInterface mainPlayerDAO,
                                   AddMainPlayerScoreboardDataAccessInterface scoreboardDAO,
                                   AddMainPlayerGameStateDataAccessInterface gameStateDAO,
                                   ScoreboardViewModel scoreboardViewModel,
                                   SendMessageInputBoundary sendMessageInputBoundary,
                                   JoinEnterWaitRoomController joinEnterWaitRoomController,
                                   HostEnterWaitRoomController hostEnterWaitRoomController,
                                   AddMainPlayerOutputBoundary addMainPlayerPresenter) {
        this.playerDAO = mainPlayerDAO;
        this.scoreboardDAO = scoreboardDAO;
        this.gameStateDAO = gameStateDAO;
        this.scoreboardViewModel = scoreboardViewModel;
        this.sendMessageInputBoundary = sendMessageInputBoundary;
        this.joinEnterWaitRoomController = joinEnterWaitRoomController;
        this.hostEnterWaitRoomController = hostEnterWaitRoomController;
        this.addMainPlayerPresenter = addMainPlayerPresenter;
    }

    public void execute(AddMainPlayerInputData addMainPlayerInputData){
        // check if name is empty
        if (addMainPlayerInputData.getMainPlayerName() == null) {
            if (addMainPlayerInputData.isHost()) {
                hostEnterWaitRoomController.execute(addMainPlayerInputData.getLobbyID(), "Empty name");
            } else {
                joinEnterWaitRoomController.execute(addMainPlayerInputData.getLobbyID(), "Empty name");
            }
        }
        // check if there already is a player with the same name
        else if (!playerDAO.existsByName(addMainPlayerInputData.getMainPlayerName())) {
            Player mainPlayer = new Player(addMainPlayerInputData.getMainPlayerName());
            playerDAO.save(mainPlayer);
            scoreboardDAO.getScoreboard().addPlayer(mainPlayer);
            gameStateDAO.getGameState().addPlayer(mainPlayer);
            // This is where we set the main player (AddPlayer use case only adds the player)
            gameStateDAO.getGameState().setMainPlayer(mainPlayer);
            ScoreboardState state = this.scoreboardViewModel.getState();
            state.addPlayer(mainPlayer.getName());
            this.scoreboardViewModel.firePropertyChanged();

            // send a message to let other joined clients know that a new player has joined the lobby
            String content = addMainPlayerInputData.getMainPlayerName() + " has joined.";

            SendMessageInputData sendMessageInputData = new SendMessageInputData(content, null, Message.MessageType.SYSTEM);
            this.sendMessageInputBoundary.execute(sendMessageInputData);

            // update channel topic so that future joining players know to add this player
            AddMainPlayerOutputData outputData = new AddMainPlayerOutputData(addMainPlayerInputData.getMainPlayerName(), addMainPlayerInputData.isHost());
            addMainPlayerPresenter.updateChannel(outputData);

            // update view
            if (addMainPlayerInputData.isHost()) {
                hostEnterWaitRoomController.execute(addMainPlayerInputData.getLobbyID(), null);
            } else {
                joinEnterWaitRoomController.execute(addMainPlayerInputData.getLobbyID(), null);
            }
        } else {
            if (addMainPlayerInputData.isHost()) {
                hostEnterWaitRoomController.execute(addMainPlayerInputData.getLobbyID(), "Name taken");
            } else {
                joinEnterWaitRoomController.execute(addMainPlayerInputData.getLobbyID(), "Name taken");
            }
        }
    }
}
