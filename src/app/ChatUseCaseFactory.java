package app;

import entity.Player;
import interface_adapter.Chat.ChatViewModel;
import interface_adapter.PlayerGuess.PlayerGuessController;
import interface_adapter.PlayerGuess.PlayerGuessPresenter;
import interface_adapter.PlayerGuess.PlayerGuessViewModel;
import interface_adapter.SendMessage.SendMessageController;
import interface_adapter.SendMessage.SendMessageLoggerModel;
import interface_adapter.SendMessage.SendMessagePresenter;
import use_case.PlayerGuess.PlayerGuessDataAccessInterface;
import use_case.PlayerGuess.PlayerGuessInteractor;
import use_case.SendMessage.*;
import view.ChatView;

public class ChatUseCaseFactory {
    private ChatUseCaseFactory() {}
    public static ChatView create(SendMessageMainPlayerDataAccessInterface mainPlayerDataAccessObject, ChatViewModel chatViewModel, SendMessageLoggerModel sendMessageLoggerModel, PlayerGuessViewModel playerGuessViewModel, PlayerGuessDataAccessInterface playerGuessDataAccessInterface) {
        SendMessageController sendMessageController = createSendMessageUseCase(mainPlayerDataAccessObject, sendMessageLoggerModel);
        PlayerGuessController playerGuessController = createPlayerGuessController(playerGuessViewModel, playerGuessDataAccessInterface);
        return new ChatView(chatViewModel, sendMessageController, playerGuessController);
    }
    private static SendMessageController createSendMessageUseCase(SendMessageMainPlayerDataAccessInterface mainPlayerDataAccessObject, SendMessageLoggerModel sendMessageLoggerModel) {
        SendMessageOutputBoundary sendMessageOutputBoundary = new SendMessagePresenter(sendMessageLoggerModel);
        SendMessageInputBoundary sendMessageInputBoundary = new SendMessageInteractor(mainPlayerDataAccessObject, sendMessageOutputBoundary);
        return new SendMessageController(sendMessageInputBoundary);
    }

    private static PlayerGuessController createPlayerGuessController(PlayerGuessViewModel playerGuessViewModel, PlayerGuessDataAccessInterface playerGuessDataAccessInterface){
        PlayerGuessPresenter playerGuessPresenter = new PlayerGuessPresenter(playerGuessViewModel);
        PlayerGuessInteractor playerGuessInteractor = new PlayerGuessInteractor(playerGuessDataAccessInterface, playerGuessPresenter);
        return new PlayerGuessController(playerGuessInteractor);
}

}
