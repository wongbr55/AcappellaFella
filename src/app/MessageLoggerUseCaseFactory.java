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

    public static MessageLogger create(ReceiveMessageMessageHistoryDataAccessInterface messageHistoryDataAccessObject, ReceiveMessagePlayerDataAccessInterface playerDataAccessObject, SendMessageLoggerModel sendMessageLoggerModel, ChatViewModel chatViewModel) {
        ReceiveMessageController receiveMessageController = createMessageLoggerUseCase(messageHistoryDataAccessObject, playerDataAccessObject, chatViewModel);
        return new MessageLogger(sendMessageLoggerModel, receiveMessageController);
    }

    private static ReceiveMessageController createMessageLoggerUseCase(ReceiveMessageMessageHistoryDataAccessInterface messageHistoryDataAccessObject, ReceiveMessagePlayerDataAccessInterface playerDataAccessObject, ChatViewModel chatViewModel) {
        ReceiveMessageOutputBoundary receiveMessageOutputBoundary = new ReceiveMessagePresenter(chatViewModel);
        ReceiveMessageInputBoundary receiveMessageInputBoundary = new ReceiveMessageInteractor(messageHistoryDataAccessObject, playerDataAccessObject, receiveMessageOutputBoundary);
        return new ReceiveMessageController(receiveMessageInputBoundary);
    }

}
