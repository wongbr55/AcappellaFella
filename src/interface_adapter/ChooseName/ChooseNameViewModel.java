package interface_adapter.ChooseName;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class ChooseNameViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Choose a name";
    public final String JOIN_LOBBY_LABEL = "Join Lobby";
    private ChooseNameState state = new ChooseNameState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public ChooseNameViewModel(String viewName) {
        super(viewName);
    }
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ChooseNameState getState() {
        return state;
    }

    public void setState(ChooseNameState state) {
        this.state = state;
    }
}
