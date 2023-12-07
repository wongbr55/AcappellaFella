package interface_adapter.EnterChooseName.JoinEnterChooseName;

import org.junit.Before;
import org.junit.Test;
import use_case.EnterChooseName.JoinEnterChooseName.JoinEnterChooseNameInputBoundary;
import use_case.EnterChooseName.JoinEnterChooseName.JoinEnterChooseNameInputData;
import use_case.JoinLobby.JoinLobbyInputBoundary;

import static org.junit.Assert.*;

public class JoinEnterChooseNameControllerTest {

    JoinEnterChooseNameController joinEnterChooseNameController;
    JoinEnterChooseNameInputBoundary joinEnterChooseNameInputBoundary;
    @Before
    public void setUp() {
        joinEnterChooseNameInputBoundary = new JoinEnterChooseNameInputBoundary() {
            @Override
            public void execute(JoinEnterChooseNameInputData joinEnterChooseNameInputData) {

            }
        };
        joinEnterChooseNameController = new JoinEnterChooseNameController(joinEnterChooseNameInputBoundary);
    }

    @Test
    public void execute() {
        joinEnterChooseNameController.execute("1");
    }
}