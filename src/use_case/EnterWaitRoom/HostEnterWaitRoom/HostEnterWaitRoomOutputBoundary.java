package use_case.EnterWaitRoom.HostEnterWaitRoom;

public interface HostEnterWaitRoomOutputBoundary {
    void prepareSuccessView(HostEnterWaitRoomOutputData hostEnterWaitRoomOutputData);
    void prepareFailView(String error);
}
