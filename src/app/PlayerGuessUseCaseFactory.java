package app;

import interface_adapter.Chat.ChatViewModel;
import interface_adapter.PlayerGuess.PlayerGuessController;
import interface_adapter.PlayerGuess.PlayerGuessPresenter;
import interface_adapter.PlayerGuess.PlayerGuessViewModel;
import interface_adapter.SendMessage.SendMessageLoggerModel;
import use_case.PlayerGuess.PlayerGuessDataAccessInterface;
import use_case.PlayerGuess.PlayerGuessInteractor;
import use_case.SendMessage.SendMessageMainPlayerDataAccessInterface;
import view.ChatView;
import view.PlayerGuessView;

public class PlayerGuessUseCaseFactory {
    private PlayerGuessUseCaseFactory(){}

    public static PlayerGuessView create(PlayerGuessViewModel playerGuessViewModel, PlayerGuessDataAccessInterface playerGuessDataAccessInterface,
                                         SendMessageMainPlayerDataAccessInterface mainPlayerDataAccessObject, ChatViewModel chatViewModel,
                                         SendMessageLoggerModel sendMessageLoggerModel){
        PlayerGuessPresenter playerGuessPresenter = new PlayerGuessPresenter(playerGuessViewModel);
        PlayerGuessInteractor playerGuessInteractor = new PlayerGuessInteractor(playerGuessDataAccessInterface, playerGuessPresenter);
        PlayerGuessController playerGuessController = new PlayerGuessController(playerGuessInteractor);

        ChatView chatView = ChatUseCaseFactory.create(mainPlayerDataAccessObject, chatViewModel, sendMessageLoggerModel, playerGuessController);

        return new PlayerGuessView(playerGuessViewModel, playerGuessController, chatView);
    }
}
