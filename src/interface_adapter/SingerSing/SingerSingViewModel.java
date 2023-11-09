package interface_adapter.SingerSing;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class SingerSingViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Start Singing!";
    public SingerSingViewModel() {super("singer sing");}

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
