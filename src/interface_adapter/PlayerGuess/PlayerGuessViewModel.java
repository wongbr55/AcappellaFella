package interface_adapter.PlayerGuess;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class PlayerGuessViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Guess the Song!";

    public PlayerGuessViewModel(){
        super("player guess");
    }

    public String getTitleLabel(){
        return this.TITLE_LABEL;
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
