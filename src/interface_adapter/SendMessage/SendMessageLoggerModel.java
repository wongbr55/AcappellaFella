package interface_adapter.SendMessage;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SendMessageLoggerModel {
    private SendMessageState state = new SendMessageState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

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
