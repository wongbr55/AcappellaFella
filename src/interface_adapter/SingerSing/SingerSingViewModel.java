package interface_adapter.SingerSing;

import interface_adapter.SingerChoose.SingerChooseState;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SingerSingViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Start Singing!";

    public static String SONG_LABEL;

    private SingerSingState state = new SingerSingState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public SingerSingViewModel() {super("singer sing");}

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

    public String getSongLabel() {return SONG_LABEL;}

    public void setSongLabel(String songLabel) {SONG_LABEL = songLabel;}
}
