package interface_adapter.Chat;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ChatViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Send a Message";
    public static final String TYPE_LABEL = "Message...";
    public static final String SEND_BUTTON_LABEL = "Send";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private ChatState state = new ChatState();

    public ChatViewModel() {
        super("logger");
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ChatState getState() {
        return state;
    }

    public void setState(ChatState state) {
        this.state = state;
    }
}
