package interface_adapter.UpdateScore;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class UpdateScoreViewModel extends ViewModel {

    private UpdateScoreState state = new UpdateScoreState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public UpdateScoreViewModel(){
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
    public UpdateScoreState getState() {
        return state;
    }

    public void setState(UpdateScoreState state){
        this.state = state;
    }


}
