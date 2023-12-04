package interface_adapter.WaitRoom;

import interface_adapter.ViewModel;
import view.JoinWaitRoomView;
import view.HostWaitRoomView;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class WaitRoomViewModel extends ViewModel {
    public static final String START_GAME_BUTTON_LABEL = "Start game";
    public static final String LOAD_PLAYLIST_BUTTON_LABEL = "Load";
    private WaitRoomState state = new WaitRoomState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public WaitRoomViewModel(String ViewName) {
        super(ViewName);
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public WaitRoomState getState() {
        return state;
    }

    public void setState(WaitRoomState state) {
        this.state = state;
    }
}