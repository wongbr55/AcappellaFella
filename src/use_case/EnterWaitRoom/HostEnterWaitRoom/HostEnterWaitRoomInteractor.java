package use_case.EnterWaitRoom.HostEnterWaitRoom;

public class HostEnterWaitRoomInteractor implements HostEnterWaitRoomInputBoundary {
    private final HostEnterWaitRoomOutputBoundary hostEnterWaitRoomPresenter;

    public HostEnterWaitRoomInteractor(HostEnterWaitRoomOutputBoundary hostEnterWaitRoomPresenter) {
        this.hostEnterWaitRoomPresenter = hostEnterWaitRoomPresenter;
    }

    @Override
    public void execute(HostEnterWaitRoomInputData hostEnterWaitRoomInputData) {
        if (hostEnterWaitRoomInputData.getNameError() == null) {
            HostEnterWaitRoomOutputData hostEnterWaitRoomOutputData = new HostEnterWaitRoomOutputData(hostEnterWaitRoomInputData.getLobbyID());
            hostEnterWaitRoomPresenter.prepareSuccessView(hostEnterWaitRoomOutputData);
        } else {
            hostEnterWaitRoomPresenter.prepareFailView(hostEnterWaitRoomInputData.getNameError());
        }
    }
}
