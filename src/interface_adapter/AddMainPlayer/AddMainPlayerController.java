package interface_adapter.AddMainPlayer;

import use_case.AddMainPlayer.AddMainPlayerInputBoundary;
import use_case.AddMainPlayer.AddMainPlayerInputData;

public class AddMainPlayerController {
    private AddMainPlayerInputBoundary addMainPlayerInteractor;

    public AddMainPlayerController(AddMainPlayerInputBoundary addMainPlayerInteractor) {
        this.addMainPlayerInteractor = addMainPlayerInteractor;
    }

    public void execute(String mainPlayerName, String lobbyID, boolean host) {
        AddMainPlayerInputData addMainPlayerInputData = new AddMainPlayerInputData(mainPlayerName, lobbyID, host);
        this.addMainPlayerInteractor.execute(addMainPlayerInputData);
    }
}
