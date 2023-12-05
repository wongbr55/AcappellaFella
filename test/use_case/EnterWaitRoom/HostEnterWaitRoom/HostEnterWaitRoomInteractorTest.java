package use_case.EnterWaitRoom.HostEnterWaitRoom;

import interface_adapter.EnterWaitRoom.HostEnterWaitRoom.HostEnterWaitRoomController;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HostEnterWaitRoomInteractorTest {

    private HostEnterWaitRoomInteractor hostEnterWaitRoomInteractor;
    @Before
    public void setUp() {
        HostEnterWaitRoomOutputBoundary hostEnterWaitRoomOutputBoundary = new HostEnterWaitRoomOutputBoundary() {
            @Override
            public void prepareSuccessView(HostEnterWaitRoomOutputData hostEnterWaitRoomOutputData) {

            }

            @Override
            public void prepareFailView(String error) {

            }
        };

        hostEnterWaitRoomInteractor = new HostEnterWaitRoomInteractor(hostEnterWaitRoomOutputBoundary);
    }

    @Test
    public void execute() {
        HostEnterWaitRoomInputData hostEnterWaitRoomInputData = new HostEnterWaitRoomInputData("123", "Brandon");
        hostEnterWaitRoomInteractor.execute(hostEnterWaitRoomInputData);

        HostEnterWaitRoomInputData hostEnterWaitRoomInputData1 = new HostEnterWaitRoomInputData("123", null);
        hostEnterWaitRoomInteractor.execute(hostEnterWaitRoomInputData1);

    }
}