package use_case.UpdateScore;

import entity.*;

public class UpdateScoreInteractor implements UpdateScoreInputBoundary {

    private final UpdateScoreScoreboardDataAccessInterface updateScoreScoreboardDataAccessInterface;
    private final UpdateScoreRoundStateDataAccessInterface updateScoreRoundStateDataAccessInterface;

    private final UpdateScoreOutputBoundary updateScorePresenter;


    public UpdateScoreInteractor(UpdateScoreScoreboardDataAccessInterface updateScoreScoreboardDataAccessInterface, UpdateScoreRoundStateDataAccessInterface updateScoreRoundStateDataAccessInterface, UpdateScoreOutputBoundary updateScorePresenter) {
        this.updateScoreScoreboardDataAccessInterface = updateScoreScoreboardDataAccessInterface;
        this.updateScoreRoundStateDataAccessInterface = updateScoreRoundStateDataAccessInterface;
        this.updateScorePresenter = updateScorePresenter;
    }

    public void execute(UpdateScoreInputData updateScoreInputData) {
        // make one DAI for receiving the scoreboard
        // make one DAI for retrieving the roundstate

        RoundState roundState = updateScoreRoundStateDataAccessInterface.getCurrentRoundState();
        Scoreboard scoreboard = updateScoreScoreboardDataAccessInterface.getScoreboard();

        // get the name of the player who most recently guessed right
        Player player = updateScoreInputData.getPlayer();

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
