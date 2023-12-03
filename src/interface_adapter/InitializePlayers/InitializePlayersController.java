package interface_adapter.InitializePlayers;

import use_case.InitializePlayers.InitializePlayersInputBoundary;
import use_case.InitializePlayers.InitializePlayersInputData;

import java.util.List;

public class InitializePlayersController {
    private final InitializePlayersInputBoundary initializePlayersInteractor;

    public InitializePlayersController(InitializePlayersInputBoundary initializePlayersInteractor) {
        this.initializePlayersInteractor = initializePlayersInteractor;
    }

    public void execute(List<String> playerNames) {
        InitializePlayersInputData initializePlayersInputData = new InitializePlayersInputData(playerNames);
        initializePlayersInteractor.execute(initializePlayersInputData);
    }
}
