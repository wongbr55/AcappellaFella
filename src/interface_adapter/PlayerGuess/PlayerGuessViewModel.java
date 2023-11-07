package interface_adapter.PlayerGuess;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PlayerGuessViewModel extends ViewModel {

    private PlayerGuessState playerGuessState = new PlayerGuessState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public PlayerGuessViewModel(){
        super("player guess");
    }

    public void setState(PlayerGuessState playerGuessState){
        this.playerGuessState = playerGuessState;
    }

    public PlayerGuessState getState(){
        return this.playerGuessState;
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
