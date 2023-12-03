package use_case.AddMainPlayer;

import entity.Player;
import interface_adapter.Scoreboard.ScoreboardState;
import interface_adapter.Scoreboard.ScoreboardViewModel;

public class AddMainPlayerInteractor implements AddMainPlayerInputBoundary {

    private final AddMainPlayerPlayerDataAccessInterface mainPlayerDAO;
    private final AddMainPlayerScoreboardDataAccessInterface scoreboardDAO;
    private final AddMainPlayerGameStateDataAccessInterface gameStateDAO;
    private final ScoreboardViewModel scoreboardViewModel;


    public AddMainPlayerInteractor(AddMainPlayerPlayerDataAccessInterface mainPlayerDAO, AddMainPlayerScoreboardDataAccessInterface scoreboardDAO, AddMainPlayerGameStateDataAccessInterface gameStateDAO, ScoreboardViewModel scoreboardViewModel) {
        this.mainPlayerDAO = mainPlayerDAO;
        this.scoreboardDAO = scoreboardDAO;
        this.gameStateDAO = gameStateDAO;
        this.scoreboardViewModel = scoreboardViewModel;
    }

    public void execute(AddMainPlayerInputData addMainPlayerInputData){
        Player mainPlayer = new Player(addMainPlayerInputData.getMainPlayerName());
        mainPlayerDAO.save(mainPlayer);
        scoreboardDAO.getScoreboard().addPlayer(mainPlayer);
        gameStateDAO.getGameState().addPlayer(mainPlayer);
        // This is where we set the main player (AddPlayer use case only adds the player)
        gameStateDAO.getGameState().setMainPlayer(mainPlayer);
        ScoreboardState state = this.scoreboardViewModel.getState();
        state.addPlayer(mainPlayer.getName());
        this.scoreboardViewModel.firePropertyChanged();
    }
}
