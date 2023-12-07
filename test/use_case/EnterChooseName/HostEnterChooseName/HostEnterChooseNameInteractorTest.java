package use_case.EnterChooseName.HostEnterChooseName;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HostEnterChooseNameInteractorTest {

    private HostEnterChooseNameInteractor chooseNameInteractor;
    @Before
    public void setUp() {
        HostEnterChooseNameOutputBoundary chooseNameOutputBoundary = new HostEnterChooseNameOutputBoundary() {
            @Override
            public void prepareSuccessView(HostEnterChooseNameOutputData hostEnterChooseNameOutputData) {

            }
        };
        chooseNameInteractor = new HostEnterChooseNameInteractor(chooseNameOutputBoundary);
    }

    @Test
    public void execute() {
        HostEnterChooseNameInputData chooseNameInputData = new HostEnterChooseNameInputData("123");
        chooseNameInteractor.execute(chooseNameInputData);
    }
}