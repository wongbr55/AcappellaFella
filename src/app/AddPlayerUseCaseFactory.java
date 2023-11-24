package app;

import interface_adapter.AddPlayer.AddPlayerController;
import interface_adapter.Scoreboard.ScoreboardViewModel;
import use_case.AddPlayer.*;

public class AddPlayerUseCaseFactory {

    private AddPlayerUseCaseFactory(){}

    public static AddPlayerController create(AddPlayerScoreboardDataAccessInterface addPlayerScoreboardDataAccessInterface,
                  AddPlayerPlayerDataAccessInterface addPlayerPlayerDataAccessInterface,
                  AddPlayerGameStateDataAccessInterace addPlayerGameStateDataAccessInterace,
                  ScoreboardViewModel scoreboardViewModel){
        AddPlayerInputBoundary addPlayerInputBoundary = new AddPlayerInteractor(addPlayerGameStateDataAccessInterace, addPlayerScoreboardDataAccessInterface,
                addPlayerPlayerDataAccessInterface, scoreboardViewModel);
        return new AddPlayerController(addPlayerInputBoundary);
    }

}
