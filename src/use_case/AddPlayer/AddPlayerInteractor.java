package use_case.AddPlayer;

import entity.Player;
import interface_adapter.UpdateScore.UpdateScoreState;
import interface_adapter.UpdateScore.UpdateScoreViewModel;

public class AddPlayerInteractor implements AddPlayerInputBoundary{

    private final AddPlayerPlayerDataAccessInterface playerDAO;
    private final AddPlayerScoreboardDataAccessInterface scoreboardDAO;
    private final AddPlayerGameStateDataAccessInterace gameStateDAO;
    private final UpdateScoreViewModel updateScoreViewModel;

    // todo refactor to work with the wait lobby

    public AddPlayerInteractor(AddPlayerGameStateDataAccessInterace addPlayerGameStateDataAccessInterace,
                                AddPlayerScoreboardDataAccessInterface addPlayerScoreboardDataAccessInterface,
                               AddPlayerPlayerDataAccessInterface addPlayerPlayerDataAccessInterface,
                               UpdateScoreViewModel updateScoreViewModel){
        this.playerDAO = addPlayerPlayerDataAccessInterface;
        this.gameStateDAO = addPlayerGameStateDataAccessInterace;
        this.scoreboardDAO = addPlayerScoreboardDataAccessInterface;
        this.updateScoreViewModel = updateScoreViewModel;
    }

    @Override
    public void execute(AddPlayerInputData addPlayerInputData) {
        Player newPlayer = addPlayerInputData.getPlayer();
        playerDAO.save(newPlayer);
        gameStateDAO.getGameState().addPlayer(newPlayer);
        scoreboardDAO.getScoreboard().addPlayer(newPlayer);
        UpdateScoreState state = this.updateScoreViewModel.getState();
        state.addPlayer(newPlayer);
        this.updateScoreViewModel.firePropertyChanged();
        // todo again need to update the wait room view

    }
}
