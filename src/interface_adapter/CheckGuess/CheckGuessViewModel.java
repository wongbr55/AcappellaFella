package interface_adapter.CheckGuess;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CheckGuessViewModel extends ViewModel {
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private CheckGuessState checkGuessState = new CheckGuessState();

    public CheckGuessViewModel() {
        super("player guess");
    }

    public CheckGuessState getState() {
        return this.checkGuessState;
    }

    public void setState(CheckGuessState checkGuessState) {
        this.checkGuessState = checkGuessState;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.checkGuessState);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
