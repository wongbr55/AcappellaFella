package use_case.JoinLobby;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JoinLobbyInteractorTest {

    JoinLobbyInteractor joinLobbyInteractor;
    @Before
    public void setUp() {
        JoinLobbyOutputBoundary joinLobbyOutputBoundary = new JoinLobbyOutputBoundary() {
            @Override
            public void prepareSuccessView(JoinLobbyOutputData joinLobbyOutputData) {

            }
        };
        joinLobbyInteractor = new JoinLobbyInteractor(joinLobbyOutputBoundary);
    }

    @Test
    public void execute() {
        JoinLobbyInputData joinLobbyInputData = new JoinLobbyInputData("123");
        joinLobbyInteractor.execute(joinLobbyInputData);
    }
}