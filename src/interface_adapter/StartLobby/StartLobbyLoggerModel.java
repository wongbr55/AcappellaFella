package interface_adapter.StartLobby;

import interface_adapter.SendMessage.SendMessageState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class StartLobbyLoggerModel {
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private StartLobbyState state = new StartLobbyState();
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public StartLobbyState getState() {
        return state;
    }

    public void setState(StartLobbyState state) {
        this.state = state;
    }
}
