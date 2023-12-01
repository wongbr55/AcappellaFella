package interface_adapter.EndScreen;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EndScreenViewModel extends ViewModel {

    EndScreenState state = new EndScreenState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public EndScreenViewModel() {
        super("end screen");
    }

    public EndScreenState getState(){
        return this.state;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
