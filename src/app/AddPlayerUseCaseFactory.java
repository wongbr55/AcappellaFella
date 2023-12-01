package app;

import interface_adapter.AddPlayer.AddPlayerController;
import interface_adapter.Scoreboard.ScoreboardViewModel;
import use_case.AddPlayer.*;

public class AddPlayerUseCaseFactory {

    private AddPlayerUseCaseFactory(){}

    public static AddPlayerController create(AddPlayerScoreboardDataAccessInterface addPlayerScoreboardDataAccessInterface,
                  AddPlayerPlayerDataAccessInterface addPlayerPlayerDataAccessInterface,
                  AddPlayerGameStateDataAccessInterface addPlayerGameStateDataAccessInterface,
                  ScoreboardViewModel scoreboardViewModel){
        AddPlayerInputBoundary addPlayerInputBoundary = new AddPlayerInteractor(addPlayerGameStateDataAccessInterface, addPlayerScoreboardDataAccessInterface,
                addPlayerPlayerDataAccessInterface, scoreboardViewModel);
        return new AddPlayerController(addPlayerInputBoundary);
    }

}
