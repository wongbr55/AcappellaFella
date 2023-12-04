package interface_adapter.SingerChoose;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SingerChooseViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Choose a song!";
    private SingerChooseState state = new SingerChooseState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public SingerChooseViewModel() {
        super("singer choose");
    }

    // This is what the SingerChoose Presenter will call to let the ViewModel know
    // to alert the View
    @Override
    public void firePropertyChanged() {
    support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public SingerChooseState getState() {
        return state;
    }

    public void setState(SingerChooseState state) {
        this.state = state;
    }
}
