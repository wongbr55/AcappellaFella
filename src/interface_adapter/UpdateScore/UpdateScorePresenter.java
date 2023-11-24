package interface_adapter.UpdateScore;

import entity.Player;
import interface_adapter.Scoreboard.ScoreboardViewModel;
import use_case.UpdateScore.UpdateScoreOutputBoundary;
import use_case.UpdateScore.UpdateScoreOutputData;

import java.util.Map;

public class UpdateScorePresenter implements UpdateScoreOutputBoundary {
    private final ScoreboardViewModel scoreboardViewModel;
//    private final ViewManagerModel viewManagerModel;

    public UpdateScorePresenter(ScoreboardViewModel scoreboardViewModel) {
        this.scoreboardViewModel = scoreboardViewModel;
//        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(UpdateScoreOutputData updateScoreOutputData) {
        // add ScoreboardView to PlayerGuessView
        Map<Player, Integer> scoreboard = this.scoreboardViewModel.getState().getScoreboard();
        Player player = updateScoreOutputData.getPlayer();
        Integer score = updateScoreOutputData.getScore();
        scoreboard.put(player, score);
        this.scoreboardViewModel.firePropertyChanged();

    }
}
