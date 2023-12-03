package use_case.EnterWaitRoom.JoinEnterWaitRoom;

public interface JoinEnterWaitRoomOutputBoundary {
    void prepareSuccessView(JoinEnterWaitRoomOutputData joinEnterWaitRoomOutputData);
    void prepareFailView(String error);
}
