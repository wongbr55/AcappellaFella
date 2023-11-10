package interface_adapter.PlayerGuess;

import interface_adapter.PlayerGuess.PlayerGuessState;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PlayerGuessViewModel extends ViewModel {
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private PlayerGuessState playerGuessState = new PlayerGuessState();

    public PlayerGuessViewModel() {
        super("player guess");
    }

    public PlayerGuessState getState() {
        return this.playerGuessState;
    }

    public void setState(PlayerGuessState playerGuessState) {
        this.playerGuessState = playerGuessState;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.playerGuessState);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
