package use_case.InitializePlayers;

import interface_adapter.AddPlayer.AddPlayerController;

public class InitializePlayersInteractor implements InitializePlayersInputBoundary {
    private final AddPlayerController addPlayerController;

    public InitializePlayersInteractor(AddPlayerController addPlayerController) {
        this.addPlayerController = addPlayerController;
    }

    @Override
    public void execute(InitializePlayersInputData initializePlayersInputData) {
        for (String playerName : initializePlayersInputData.getPlayerNames()) {
            addPlayerController.execute(playerName);
        }
    }
}
