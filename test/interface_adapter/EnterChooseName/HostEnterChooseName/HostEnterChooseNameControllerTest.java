package interface_adapter.EnterChooseName.HostEnterChooseName;

import org.junit.Before;
import org.junit.Test;
import use_case.EnterChooseName.HostEnterChooseName.HostEnterChooseNameInputBoundary;
import use_case.EnterChooseName.HostEnterChooseName.HostEnterChooseNameInputData;

import static org.junit.Assert.*;

public class HostEnterChooseNameControllerTest {

    HostEnterChooseNameController hostEnterChooseNameController;
    HostEnterChooseNameInputBoundary hostEnterChooseNameInputBoundary;
    @Before
    public void setUp() {
        hostEnterChooseNameInputBoundary = new HostEnterChooseNameInputBoundary() {
            @Override
            public void execute(HostEnterChooseNameInputData hostEnterChooseNameInputData) {

            }
        };
        hostEnterChooseNameController = new HostEnterChooseNameController(hostEnterChooseNameInputBoundary);
    }

    @Test
    public void execute() {
        hostEnterChooseNameController.execute("1");
    }
}