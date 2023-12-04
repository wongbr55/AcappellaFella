package interface_adapter.JoinLobby;

import interface_adapter.StartLobby.StartLobbyState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class JoinLobbyLoggerModel {
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private JoinLobbyState state = new JoinLobbyState();
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public JoinLobbyState getState() {
        return state;
    }

    public void setState(JoinLobbyState state) {
        this.state = state;
    }
}
