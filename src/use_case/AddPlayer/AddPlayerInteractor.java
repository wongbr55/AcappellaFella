package use_case.AddPlayer;

import entity.Player;
import interface_adapter.Scoreboard.ScoreboardState;
import interface_adapter.Scoreboard.ScoreboardViewModel;

public class AddPlayerInteractor implements AddPlayerInputBoundary{

    private final AddPlayerPlayerDataAccessInterface playerDAO;
    private final AddPlayerScoreboardDataAccessInterface scoreboardDAO;
    private final AddPlayerGameStateDataAccessInterface gameStateDAO;
    private final ScoreboardViewModel scoreboardViewModel;

    // todo refactor to work with the wait lobby

    public AddPlayerInteractor(AddPlayerGameStateDataAccessInterface addPlayerGameStateDataAccessInterface,
                               AddPlayerScoreboardDataAccessInterface addPlayerScoreboardDataAccessInterface,
                               AddPlayerPlayerDataAccessInterface addPlayerPlayerDataAccessInterface,
                               ScoreboardViewModel scoreboardViewModel){
        this.playerDAO = addPlayerPlayerDataAccessInterface;
        this.gameStateDAO = addPlayerGameStateDataAccessInterface;
        this.scoreboardDAO = addPlayerScoreboardDataAccessInterface;
        this.scoreboardViewModel = scoreboardViewModel;
    }

    @Override
    public void execute(AddPlayerInputData addPlayerInputData) {
        Player newPlayer = new Player(addPlayerInputData.getPlayerName());
        playerDAO.save(newPlayer);
        gameStateDAO.getGameState().addPlayer(newPlayer);
        scoreboardDAO.getScoreboard().addPlayer(newPlayer);
        ScoreboardState state = this.scoreboardViewModel.getState();
        state.addPlayer(newPlayer.getName());
        this.scoreboardViewModel.firePropertyChanged();
    }
}
