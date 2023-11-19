package app;

import interface_adapter.UpdateScore.UpdateScorePresenter;
import interface_adapter.UpdateScore.UpdateScoreViewModel;
import use_case.UpdateScore.UpdateScoreDataAccessInterface;
import use_case.UpdateScore.UpdateScoreInteractor;
import use_case.UpdateScore.UpdateScoreRoundStateDataAccessInterface;

public class UpdateScoreUseCaseFactory {
    public static UpdateScoreInteractor create(UpdateScoreDataAccessInterface updateScoreDataAccessInterface, UpdateScoreRoundStateDataAccessInterface updateScoreRoundStateDataAccessInterface, UpdateScoreViewModel updateScoreViewModel) {
        UpdateScorePresenter updateScorePresenter = new UpdateScorePresenter(updateScoreViewModel);
        return new UpdateScoreInteractor(updateScoreDataAccessInterface, updateScoreRoundStateDataAccessInterface, updateScorePresenter);
    }
}
