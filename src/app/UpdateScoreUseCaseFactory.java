package app;

import interface_adapter.UpdateScore.UpdateScorePresenter;
import interface_adapter.Scoreboard.ScoreboardViewModel;
import use_case.UpdateScore.UpdateScoreScoreboardDataAccessInterface;
import use_case.UpdateScore.UpdateScoreInteractor;
import use_case.UpdateScore.UpdateScoreRoundStateDataAccessInterface;

public class UpdateScoreUseCaseFactory {
    public static UpdateScoreInteractor create(UpdateScoreScoreboardDataAccessInterface updateScoreScoreboardDataAccessInterface, UpdateScoreRoundStateDataAccessInterface updateScoreRoundStateDataAccessInterface, ScoreboardViewModel scoreboardViewModel) {
        UpdateScorePresenter updateScorePresenter = new UpdateScorePresenter(scoreboardViewModel);
        return new UpdateScoreInteractor(updateScoreScoreboardDataAccessInterface, updateScoreRoundStateDataAccessInterface, updateScorePresenter);
    }
}
