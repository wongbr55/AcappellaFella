package app;

import interface_adapter.UpdateScore.UpdateScorePresenter;
import interface_adapter.Scoreboard.ScoreboardViewModel;
import use_case.UpdateScore.UpdateScoreDataAccessInterface;
import use_case.UpdateScore.UpdateScoreInteractor;
import use_case.UpdateScore.UpdateScoreRoundStateDataAccessInterface;

public class UpdateScoreUseCaseFactory {
    public static UpdateScoreInteractor create(UpdateScoreDataAccessInterface updateScoreDataAccessInterface, UpdateScoreRoundStateDataAccessInterface updateScoreRoundStateDataAccessInterface, ScoreboardViewModel scoreboardViewModel) {
        UpdateScorePresenter updateScorePresenter = new UpdateScorePresenter(scoreboardViewModel);
        return new UpdateScoreInteractor(updateScoreDataAccessInterface, updateScoreRoundStateDataAccessInterface, updateScorePresenter);
    }
}
