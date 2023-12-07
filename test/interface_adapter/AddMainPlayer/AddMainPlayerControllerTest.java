package interface_adapter.AddMainPlayer;

import org.junit.Before;
import org.junit.Test;
import use_case.AddMainPlayer.AddMainPlayerInputBoundary;
import use_case.AddMainPlayer.AddMainPlayerInputData;

import static org.junit.Assert.*;

public class AddMainPlayerControllerTest {

    private AddMainPlayerController addMainPlayerController;
    @Before
    public void setUp() {
        AddMainPlayerInputBoundary addMainPlayerInputBoundary = new AddMainPlayerInputBoundary() {
            @Override
            public void execute(AddMainPlayerInputData addMainPlayerInputData) {

            }
        };
        addMainPlayerController = new AddMainPlayerController(addMainPlayerInputBoundary);
    }

    @Test
    public void execute() {
        addMainPlayerController.execute("meeeee", "me and the boys", false);
    }
}