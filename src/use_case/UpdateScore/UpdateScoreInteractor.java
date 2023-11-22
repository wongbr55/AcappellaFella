package use_case.UpdateScore;

import entity.*;
import interface_adapter.UpdateScore.UpdateScorePresenter;

public class UpdateScoreInteractor implements UpdateScoreInputBoundary {

    private final UpdateScoreDataAccessInterface updateScoreDataAccessInterface;
    private final UpdateScoreRoundStateDataAccessInterface updateScoreRoundStateDataAccessInterface;

    private final UpdateScorePresenter updateScorePresenter;


    public UpdateScoreInteractor(UpdateScoreDataAccessInterface updateScoreDataAccessInterface, UpdateScoreRoundStateDataAccessInterface updateScoreRoundStateDataAccessInterface, UpdateScorePresenter updateScorePresenter) {
        this.updateScoreDataAccessInterface = updateScoreDataAccessInterface;
        this.updateScoreRoundStateDataAccessInterface = updateScoreRoundStateDataAccessInterface;
        this.updateScorePresenter = updateScorePresenter;
    }

    public void execute(UpdateScoreInputData updateScoreInputData) {
        // make one DAI for receiving the scoreboard
        // make one DAI for retrieving the roundstate

        RoundState roundState = updateScoreRoundStateDataAccessInterface.getCurrentRoundState();
        Scoreboard scoreboard = updateScoreDataAccessInterface.getScoreboard();

        Message message = updateScoreInputData.getMessage();
        Player player = message.getAuthor();

        // get total number of players
        Integer numPlayers = scoreboard.getNumberOfPlayers();

        // get number of correct guesses in current round
        Integer numCorrectGuesses = roundState.getTotalCorrectGuesses();

        // score is updated using total number of players minus number of correct guesses
        scoreboard.updatePlayerScore(player, numPlayers - numCorrectGuesses);

        // prepare success view
        UpdateScoreOutputData updateScoreOutputData = new UpdateScoreOutputData(player, scoreboard.getPlayerScore(player));
        updateScorePresenter.prepareSuccessView(updateScoreOutputData);

    }
}