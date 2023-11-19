package interface_adapter.UpdateScore;

import entity.Player;
import interface_adapter.ViewManagerModel;
import use_case.UpdateScore.UpdateScoreOutputBoundary;
import use_case.UpdateScore.UpdateScoreOutputData;

import java.util.Map;

public class UpdateScorePresenter implements UpdateScoreOutputBoundary {
    private final UpdateScoreViewModel updateScoreViewModel;
//    private final ViewManagerModel viewManagerModel;

    public UpdateScorePresenter(UpdateScoreViewModel updateScoreViewModel) {
        this.updateScoreViewModel = updateScoreViewModel;
//        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(UpdateScoreOutputData updateScoreOutputData) {
        // add ScoreboardView to PlayerGuessView
        Map<Player, Integer> scoreboard = this.updateScoreViewModel.getState().getScoreboard();
        Player player = updateScoreOutputData.getPlayer();
        Integer score = updateScoreOutputData.getScore();
        scoreboard.put(player, score);
        this.updateScoreViewModel.firePropertyChanged();

    }
}
