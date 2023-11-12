package interface_adapter.Scoreboard;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class ScoreboardViewModel extends ViewModel {

    private ScoreboardState scoreboardState;

    public ScoreboardViewModel(ScoreboardState scoreboardState){
        super("scoreboard");
        this.scoreboardState = scoreboardState;
    }

    public ScoreboardState getScoreboardState() {
        return scoreboardState;
    }

    public void setScoreBoardState(ScoreboardState scoreboardState){
        this.scoreboardState = scoreboardState;
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
