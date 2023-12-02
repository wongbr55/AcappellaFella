package app;

import interface_adapter.AddMainPlayer.AddMainPlayerController;
import interface_adapter.AddPlayer.AddPlayerController;
import interface_adapter.Scoreboard.ScoreboardViewModel;
import use_case.AddMainPlayer.*;
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

    public static AddMainPlayerController create(AddMainPlayerScoreboardDataAccessInterface addMainPlayerScoreboardDataAccessInterface, AddMainPlayerPlayerDataAccessInterface addMainPlayerPlayerDataAccessInterface, AddMainPlayerGameStateDataAccessInterface addMainPlayerGameStateDataAccessInterface, ScoreboardViewModel scoreboardViewModel){
        AddMainPlayerInputBoundary addMainPlayerInteractor = new AddMainPlayerInteractor(addMainPlayerPlayerDataAccessInterface, addMainPlayerScoreboardDataAccessInterface, addMainPlayerGameStateDataAccessInterface, scoreboardViewModel);
        return new AddMainPlayerController(addMainPlayerInteractor);
    }

}
