package interface_adapter.AddMainPlayer;

import interface_adapter.SendMessage.SendMessageState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddMainPlayerLoggerModel {
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private AddMainPlayerState state = new AddMainPlayerState();

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public AddMainPlayerState getState() {
        return state;
    }

    public void setState(AddMainPlayerState state) {
        this.state = state;
    }
}
