package interface_adapter.SendMessage;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SendMessageLoggerModel {
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private SendMessageState state = new SendMessageState();

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public SendMessageState getState() {
        return state;
    }

    public void setState(SendMessageState state) {
        this.state = state;
    }
}
