package interface_adapter.UpdateScore;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class UpdateScoreViewModel extends ViewModel {

    private UpdateScoreState updateScoreState;

    public UpdateScoreViewModel(UpdateScoreState updateScoreState){
        super("scoreboard");
        this.updateScoreState = updateScoreState;
    }

    public UpdateScoreState getScoreboardState() {
        return updateScoreState;
    }

    public void setScoreBoardState(UpdateScoreState updateScoreState){
        this.updateScoreState = updateScoreState;
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
