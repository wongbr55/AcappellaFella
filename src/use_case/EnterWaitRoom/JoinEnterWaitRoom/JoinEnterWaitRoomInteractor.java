package use_case.EnterWaitRoom.JoinEnterWaitRoom;

public class JoinEnterWaitRoomInteractor implements JoinEnterWaitRoomInputBoundary {
    private final JoinEnterWaitRoomOutputBoundary joinEnterWaitRoomPresenter;

    public JoinEnterWaitRoomInteractor(JoinEnterWaitRoomOutputBoundary joinEnterWaitRoomPresenter) {
        this.joinEnterWaitRoomPresenter = joinEnterWaitRoomPresenter;
    }

    @Override
    public void execute(JoinEnterWaitRoomInputData joinEnterWaitRoomInputData) {
        JoinEnterWaitRoomOutputData outputData = new JoinEnterWaitRoomOutputData(joinEnterWaitRoomInputData.getLobbyID());
        joinEnterWaitRoomPresenter.prepareSuccessView(outputData);
    }
}
