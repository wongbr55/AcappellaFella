package interface_adapter.SingerChoose;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class SingerChooseViewModel extends ViewModel {
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
}
