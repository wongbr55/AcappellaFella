package app;

import entity.Player;
import interface_adapter.Chat.ChatViewModel;
import interface_adapter.PlayerGuess.PlayerGuessController;
import interface_adapter.SendMessage.SendMessageController;
import interface_adapter.SendMessage.SendMessageLoggerModel;
import interface_adapter.SendMessage.SendMessagePresenter;
import use_case.SendMessage.*;
import view.ChatView;

public class ChatUseCaseFactory {
    private ChatUseCaseFactory() {}
    public static ChatView create(SendMessageMainPlayerDataAccessInterface mainPlayerDataAccessObject, ChatViewModel chatViewModel, SendMessageLoggerModel sendMessageLoggerModel, PlayerGuessController playerGuessController) {
        SendMessageController sendMessageController = createSendMessageUseCase(mainPlayerDataAccessObject, sendMessageLoggerModel);
        return new ChatView(chatViewModel, sendMessageController, playerGuessController);
    }
    private static SendMessageController createSendMessageUseCase(SendMessageMainPlayerDataAccessInterface mainPlayerDataAccessObject, SendMessageLoggerModel sendMessageLoggerModel) {
        SendMessageOutputBoundary sendMessageOutputBoundary = new SendMessagePresenter(sendMessageLoggerModel);
        SendMessageInputBoundary sendMessageInputBoundary = new SendMessageInteractor(mainPlayerDataAccessObject, sendMessageOutputBoundary);
        return new SendMessageController(sendMessageInputBoundary);
    }
}
