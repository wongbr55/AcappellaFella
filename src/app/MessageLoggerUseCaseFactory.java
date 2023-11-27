package app;

import interface_adapter.Chat.ChatViewModel;
import interface_adapter.ReceiveMessage.ReceiveMessageController;
import interface_adapter.ReceiveMessage.ReceiveMessagePresenter;
import interface_adapter.SendMessage.SendMessageLoggerModel;
import logger.MessageLogger;
import use_case.ReceiveMessage.*;
import use_case.UpdateScore.UpdateScoreInputBoundary;

public class MessageLoggerUseCaseFactory {
    private MessageLoggerUseCaseFactory() {
    }

    public static MessageLogger create(ReceiveMessageMessageHistoryDataAccessInterface messageHistoryDataAccessObject, ReceiveMessagePlayerDataAccessInterface playerDataAccessObject, SendMessageLoggerModel sendMessageLoggerModel, ChatViewModel chatViewModel, ReceiveMessageGameStateDataAccessInterface gameStateDataAccessObject, ReceiveMessageRoundStateDataAccessInterface roundStataDataAccessObject, UpdateScoreInputBoundary updateScoreInputBoundary) {
        ReceiveMessageController receiveMessageController = createMessageLoggerUseCase(messageHistoryDataAccessObject, playerDataAccessObject, chatViewModel, gameStateDataAccessObject, roundStataDataAccessObject, updateScoreInputBoundary);
        return new MessageLogger(sendMessageLoggerModel, receiveMessageController);
    }

    private static ReceiveMessageController createMessageLoggerUseCase(ReceiveMessageMessageHistoryDataAccessInterface messageHistoryDataAccessObject, ReceiveMessagePlayerDataAccessInterface playerDataAccessObject, ChatViewModel chatViewModel, ReceiveMessageGameStateDataAccessInterface gameStateDataAccessObject, ReceiveMessageRoundStateDataAccessInterface roundStataDataAccessObject, UpdateScoreInputBoundary updateScoreInputBoundary) {
        ReceiveMessageOutputBoundary receiveMessageOutputBoundary = new ReceiveMessagePresenter(chatViewModel);
        ReceiveMessageInputBoundary receiveMessageInputBoundary = new ReceiveMessageInteractor(gameStateDataAccessObject, roundStataDataAccessObject, messageHistoryDataAccessObject, playerDataAccessObject, receiveMessageOutputBoundary, updateScoreInputBoundary);
        return new ReceiveMessageController(receiveMessageInputBoundary);
    }

}
