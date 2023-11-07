package app;

import entity.Player;
import interface_adapter.PlayerGuess.PlayerGuessController;
import interface_adapter.PlayerGuess.PlayerGuessPresenter;
import interface_adapter.PlayerGuess.PlayerGuessViewModel;
import use_case.PlayerGuess.PlayerGuessDataAccessInterface;
import use_case.PlayerGuess.PlayerGuessInteractor;
import view.ChatView;
import view.PlayerGuessView;

public class PlayerGuessUseCaseFactory {
    private PlayerGuessUseCaseFactory(){}

    public static PlayerGuessView createView(ChatView chatView, PlayerGuessViewModel playerGuessViewModel){
        return new PlayerGuessView(chatView, playerGuessViewModel);
    }

    }
