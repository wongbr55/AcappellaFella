package interface_adapter.SingerSing;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SingerSingViewModel extends ViewModel {
    private final String TITLE_LABEL = "Start Singing!";
    private final SingerSingState state = new SingerSingState();

//    private SingerSingState state = new SingerSingState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public SingerSingViewModel() {super("singer sing");}

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public String getTitleLabel(){
        return this.TITLE_LABEL;
    }

    public String getSongLabel() {return this.state.getSongLabel();}

    public void setSongLabel(String songLabel) {this.state.setSongLabel(songLabel);}
}
