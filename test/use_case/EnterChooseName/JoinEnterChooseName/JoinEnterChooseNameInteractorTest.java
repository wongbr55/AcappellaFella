package use_case.EnterChooseName.JoinEnterChooseName;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JoinEnterChooseNameInteractorTest {

    private JoinEnterChooseNameInteractor joinEnterChooseNameInteractor;
    @Before
    public void setUp() {
        JoinEnterChooseNameOutputBoundary joinEnterChooseNameOutputBoundary = new JoinEnterChooseNameOutputBoundary() {
            @Override
            public void prepareSuccessView(JoinEnterChooseNameOutputData joinEnterChooseNameOutputData) {

            }

            @Override
            public void prepareFailView(String error) {

            }
        };

        joinEnterChooseNameInteractor = new JoinEnterChooseNameInteractor(joinEnterChooseNameOutputBoundary);
    }

    @Test
    public void execute() {

        JoinEnterChooseNameInputData joinEnterChooseNameInputData = new JoinEnterChooseNameInputData("123");
        joinEnterChooseNameInteractor.execute(joinEnterChooseNameInputData);

        JoinEnterChooseNameInputData joinEnterChooseNameInputData1 = new JoinEnterChooseNameInputData("");
        joinEnterChooseNameInteractor.execute(joinEnterChooseNameInputData1);

    }
}