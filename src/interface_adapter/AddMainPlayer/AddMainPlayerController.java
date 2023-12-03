package interface_adapter.AddMainPlayer;

import entity.Player;
import use_case.AddMainPlayer.AddMainPlayerInputBoundary;
import use_case.AddMainPlayer.AddMainPlayerInputData;

public class AddMainPlayerController {
    private AddMainPlayerInputBoundary addMainPlayerInteractor;

    public AddMainPlayerController(AddMainPlayerInputBoundary addMainPlayerInteractor) {
        this.addMainPlayerInteractor = addMainPlayerInteractor;
    }

    public void execute(String mainPlayerName) {
        AddMainPlayerInputData addMainPlayerInputData = new AddMainPlayerInputData(mainPlayerName);
        this.addMainPlayerInteractor.execute(addMainPlayerInputData);
    }
}
