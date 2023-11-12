package interface_adapter.WaitRoom;

import interface_adapter.SingerChoose.SingerChooseState;
import view.WaitRoomView;

public class WaitRoomViewModel {
    public static final String STARTLOBBY_BUTTON_LABEL = "Start Lobby";
    private WaitRoomState state = new WaitRoomState();

    public void addPropertyChangeListener(WaitRoomView waitRoomView) {
    }

    public WaitRoomState getState() {return state;}
}
