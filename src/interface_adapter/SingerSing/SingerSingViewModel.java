package interface_adapter.SingerSing;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SingerSingViewModel extends ViewModel {
    private final String TITLE_LABEL = "Start Singing!";
    private final SingerSingState singerSingState = new SingerSingState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public SingerSingViewModel() {super("singer sing");}

    public SingerSingState getState(){return this.singerSingState;}

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.singerSingState);
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public String getTitleLabel(){
        return this.TITLE_LABEL;
    }
}
