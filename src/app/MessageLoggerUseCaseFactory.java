package app;

import interface_adapter.Chat.ChatViewModel;
import interface_adapter.PlayerGuess.PlayerGuessController;
import interface_adapter.PlayerGuess.PlayerGuessPresenter;
import interface_adapter.PlayerGuess.PlayerGuessViewModel;
import interface_adapter.ReceiveMessage.ReceiveMessageController;
import interface_adapter.ReceiveMessage.ReceiveMessagePresenter;
import interface_adapter.SendMessage.SendMessageLoggerModel;
import interface_adapter.ViewManagerModel;
import logger.MessageLogger;
import use_case.PlayerGuess.PlayerGuessDataAccessInterface;
import use_case.PlayerGuess.PlayerGuessInteractor;
import use_case.ReceiveMessage.*;

public class MessageLoggerUseCaseFactory {
    private MessageLoggerUseCaseFactory() {}

    public static MessageLogger create(ReceiveMessageMessageHistoryDataAccessInterface messageHistoryDataAccessObject, ReceiveMessagePlayerDataAccessInterface playerDataAccessObject, SendMessageLoggerModel sendMessageLoggerModel, ChatViewModel chatViewModel,
                                       PlayerGuessViewModel playerGuessViewModel, PlayerGuessDataAccessInterface playerGuessDataAccessInterface, ViewManagerModel viewManagerModel) {
        ReceiveMessageController receiveMessageController = createMessageLoggerUseCase(messageHistoryDataAccessObject, playerDataAccessObject, chatViewModel, playerGuessViewModel, playerGuessDataAccessInterface, viewManagerModel);
        return new MessageLogger(sendMessageLoggerModel, receiveMessageController);
    }

    private static ReceiveMessageController createMessageLoggerUseCase(ReceiveMessageMessageHistoryDataAccessInterface messageHistoryDataAccessObject, ReceiveMessagePlayerDataAccessInterface playerDataAccessObject, ChatViewModel chatViewModel,
                                                                       PlayerGuessViewModel playerGuessViewModel, PlayerGuessDataAccessInterface playerGuessDataAccessInterface, ViewManagerModel viewManagerModel) {
        ReceiveMessageOutputBoundary receiveMessageOutputBoundary = new ReceiveMessagePresenter(chatViewModel);
        PlayerGuessInteractor playerGuessInteractor = createPlayerGuessInteractor(playerGuessViewModel, playerGuessDataAccessInterface, viewManagerModel);
        ReceiveMessageInputBoundary receiveMessageInputBoundary = new ReceiveMessageInteractor(messageHistoryDataAccessObject, playerDataAccessObject, receiveMessageOutputBoundary, playerGuessInteractor);
        return new ReceiveMessageController(receiveMessageInputBoundary);
    }

    private static PlayerGuessInteractor createPlayerGuessInteractor(PlayerGuessViewModel playerGuessViewModel, PlayerGuessDataAccessInterface playerGuessDataAccessInterface, ViewManagerModel viewManagerModel){
        PlayerGuessPresenter playerGuessPresenter = new PlayerGuessPresenter(playerGuessViewModel, viewManagerModel);
        return new PlayerGuessInteractor(playerGuessDataAccessInterface, playerGuessPresenter);
    }
}
