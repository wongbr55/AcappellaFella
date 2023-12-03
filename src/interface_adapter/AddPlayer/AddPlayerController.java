package interface_adapter.AddPlayer;

import entity.Player;
import use_case.AddPlayer.AddPlayerInputBoundary;
import use_case.AddPlayer.AddPlayerInputData;

public class AddPlayerController {
    private final AddPlayerInputBoundary addPlayerInteractor;

    public AddPlayerController(AddPlayerInputBoundary addPlayerInteractor) {
        this.addPlayerInteractor = addPlayerInteractor;
    }

    public void execute(String playerName) {
        AddPlayerInputData addPlayerInputData = new AddPlayerInputData(playerName);
        addPlayerInteractor.execute(addPlayerInputData);
    }
}
