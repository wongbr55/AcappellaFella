package interface_adapter.Scoreboard;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ScoreboardViewModel extends ViewModel {

    private ScoreboardState state = new ScoreboardState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public ScoreboardViewModel(){
        super("scoreboard");
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public ScoreboardState getState() {
        return state;
    }

    public void setState(ScoreboardState state){
        this.state = state;
    }


}
