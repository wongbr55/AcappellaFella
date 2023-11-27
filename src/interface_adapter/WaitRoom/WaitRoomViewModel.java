package interface_adapter.WaitRoom;

import view.JoinWaitRoomView;
import view.MainWaitRoomView;

public class WaitRoomViewModel {
    public static final String STARTLOBBY_BUTTON_LABEL = "Start Lobby";
    private WaitRoomState state = new WaitRoomState();

    public void addPropertyChangeListener(MainWaitRoomView mainWaitRoomView) {
    }

    public WaitRoomState getState() {return state;}

    public void setState(WaitRoomState currentState) {
    }

    public void addPropertyChangeListener(JoinWaitRoomView joinWaitRoomView) {
    }
}