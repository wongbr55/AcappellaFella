package app;

import interface_adapter.AddPlayer.AddPlayerController;
import interface_adapter.UpdateScore.UpdateScoreViewModel;
import use_case.AddPlayer.*;

public class AddPlayerUseCaseFactory {

    private AddPlayerUseCaseFactory(){}

    public static AddPlayerController create(AddPlayerScoreboardDataAccessInterface addPlayerScoreboardDataAccessInterface,
                  AddPlayerPlayerDataAccessInterface addPlayerPlayerDataAccessInterface,
                  AddPlayerGameStateDataAccessInterace addPlayerGameStateDataAccessInterace,
                  UpdateScoreViewModel updateScoreViewModel){
        AddPlayerInputBoundary addPlayerInputBoundary = new AddPlayerInteractor(addPlayerGameStateDataAccessInterace, addPlayerScoreboardDataAccessInterface,
                addPlayerPlayerDataAccessInterface, updateScoreViewModel);
        return new AddPlayerController(addPlayerInputBoundary);
    }

}
