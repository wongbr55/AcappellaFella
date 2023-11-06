package interface_adapter.PlayerGuess;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class PlayerGuessViewModel extends ViewModel {

    private PlayerGuessState playerGuessState = new PlayerGuessState();
    public PlayerGuessViewModel(){
        super("player guess");
    }

    public void setState(PlayerGuessState playerGuessState){
        this.playerGuessState = playerGuessState
    }

    public PlayerGuessState getState(){
        return this.playerGuessState;
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
