package use_case.InitializePlayers;

import interface_adapter.AddPlayer.AddPlayerController;
import org.junit.Before;
import org.junit.Test;
import use_case.AddPlayer.AddPlayerInputBoundary;
import use_case.AddPlayer.AddPlayerInputData;
import use_case.AddPlayer.AddPlayerInteractor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class InitializePlayersInteractorTest {

    private InitializePlayersInteractor initializePlayersInteractor;

    @Before
    public void setUp() {
        AddPlayerInputBoundary addPlayerInputBoundary = new AddPlayerInputBoundary() {
            @Override
            public void execute(AddPlayerInputData addPlayerInputData) {

            }
        };
        AddPlayerController addPlayerController = new AddPlayerController(addPlayerInputBoundary);

        initializePlayersInteractor = new InitializePlayersInteractor(addPlayerController);
    }

    @Test
    public void execute() {
        List<String>players = new ArrayList<>();
        players.add("Brandon");
        players.add("Mark");

        InitializePlayersInputData initializePlayersInputData = new InitializePlayersInputData(players);
        initializePlayersInteractor.execute(initializePlayersInputData);

    }
}