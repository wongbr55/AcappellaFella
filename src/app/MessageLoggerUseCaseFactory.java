package app;

import interface_adapter.Chat.ChatViewModel;
import interface_adapter.CheckGuess.CheckGuessPresenter;
import interface_adapter.CheckGuess.CheckGuessViewModel;
import interface_adapter.ReceiveMessage.ReceiveMessageController;
import interface_adapter.ReceiveMessage.ReceiveMessagePresenter;
import interface_adapter.SendMessage.SendMessageLoggerModel;
import interface_adapter.ViewManagerModel;
import logger.MessageLogger;
import use_case.CheckGuess.CheckGuessDataAccessInterface;
import use_case.CheckGuess.CheckGuessInteractor;
import use_case.ReceiveMessage.*;

public class MessageLoggerUseCaseFactory {
    private MessageLoggerUseCaseFactory() {
    }

    public static MessageLogger create(ReceiveMessageMessageHistoryDataAccessInterface messageHistoryDataAccessObject, ReceiveMessagePlayerDataAccessInterface playerDataAccessObject, SendMessageLoggerModel sendMessageLoggerModel, ChatViewModel chatViewModel,
                                       CheckGuessViewModel checkGuessViewModel, CheckGuessDataAccessInterface checkGuessDataAccessInterface, ViewManagerModel viewManagerModel) {
        ReceiveMessageController receiveMessageController = createMessageLoggerUseCase(messageHistoryDataAccessObject, playerDataAccessObject, chatViewModel, checkGuessViewModel, checkGuessDataAccessInterface, viewManagerModel);
        return new MessageLogger(sendMessageLoggerModel, receiveMessageController);
    }

    private static ReceiveMessageController createMessageLoggerUseCase(ReceiveMessageMessageHistoryDataAccessInterface messageHistoryDataAccessObject, ReceiveMessagePlayerDataAccessInterface playerDataAccessObject, ChatViewModel chatViewModel,
                                                                       CheckGuessViewModel checkGuessViewModel, CheckGuessDataAccessInterface checkGuessDataAccessInterface, ViewManagerModel viewManagerModel) {
        ReceiveMessageOutputBoundary receiveMessageOutputBoundary = new ReceiveMessagePresenter(chatViewModel);
        CheckGuessInteractor playerGuessInteractor = createPlayerGuessInteractor(checkGuessViewModel, checkGuessDataAccessInterface, viewManagerModel);
        ReceiveMessageInputBoundary receiveMessageInputBoundary = new ReceiveMessageInteractor(messageHistoryDataAccessObject, playerDataAccessObject, receiveMessageOutputBoundary, playerGuessInteractor);
        return new ReceiveMessageController(receiveMessageInputBoundary);
    }

    private static CheckGuessInteractor createPlayerGuessInteractor(CheckGuessViewModel checkGuessViewModel, CheckGuessDataAccessInterface checkGuessDataAccessInterface, ViewManagerModel viewManagerModel) {
        CheckGuessPresenter checkGuessPresenter = new CheckGuessPresenter(checkGuessViewModel, viewManagerModel);
        return new CheckGuessInteractor(checkGuessDataAccessInterface, checkGuessPresenter);
    }
}
