package interface_adapter.SingerChoose;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class SingerChooseViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Choose a song!";
    private SingerChooseState state = new SingerChooseState();

    public SingerChooseViewModel() {
        super("singer choose");
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

    public SingerChooseState getState() {
        return state;
    }

    public void setState(SingerChooseState state) {
        this.state = state;
    }
}
