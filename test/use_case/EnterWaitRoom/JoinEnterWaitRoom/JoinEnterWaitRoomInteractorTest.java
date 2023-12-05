package use_case.EnterWaitRoom.JoinEnterWaitRoom;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JoinEnterWaitRoomInteractorTest {

    private JoinEnterWaitRoomInteractor joinEnterWaitRoomInteractor;
    @Before
    public void setUp() {
        JoinEnterWaitRoomOutputBoundary joinEnterWaitRoomOutputBoundary = new JoinEnterWaitRoomOutputBoundary() {
            @Override
            public void prepareSuccessView(JoinEnterWaitRoomOutputData joinEnterWaitRoomOutputData) {

            }

            @Override
            public void prepareFailView(String error) {

            }
        };
        joinEnterWaitRoomInteractor = new JoinEnterWaitRoomInteractor(joinEnterWaitRoomOutputBoundary);
    }

    @Test
    public void execute() {
        JoinEnterWaitRoomInputData joinEnterWaitRoomInputData = new JoinEnterWaitRoomInputData("123", "Hello");
        joinEnterWaitRoomInteractor.execute(joinEnterWaitRoomInputData);
    }
}