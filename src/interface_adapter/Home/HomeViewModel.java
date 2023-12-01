package interface_adapter.Home;

import interface_adapter.SingerChoose.SingerChooseState;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class HomeViewModel extends ViewModel {
    public static final String TITLE_LABEL = "AcapellaFella";
    public static final String CREATE_BUTTON = "Create";
    public static final String JOIN_BUTTON = "Join";
    private HomeViewState state = new HomeViewState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public HomeViewModel() {
        super("home");
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public HomeViewState getState() {
        return state;
    }

    public void setState(HomeViewState state) {
        this.state = state;
    }
}
