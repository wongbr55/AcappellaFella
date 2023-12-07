package use_case.StartLobby;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StartLobbyInteractorTest {

    private StartLobbyInteractor startLobbyInteractor;
    @Before
    public void setUp() {
        StartLobbyOutputBoundary startLobbyOutputBoundary = new StartLobbyOutputBoundary() {
            @Override
            public void createLobby(StartLobbyOutputData startLobbyOutputData) {

            }
        };

        startLobbyInteractor = new StartLobbyInteractor(startLobbyOutputBoundary);
    }

    @Test
    public void execute() {
        StartLobbyInputData startLobbyInputData = new StartLobbyInputData();
        startLobbyInteractor.execute(startLobbyInputData);
    }
}