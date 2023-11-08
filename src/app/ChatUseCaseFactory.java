package app;

import interface_adapter.Chat.ChatViewModel;
import interface_adapter.SendMessage.SendMessageController;
import interface_adapter.SendMessage.SendMessageLoggerModel;
import interface_adapter.SendMessage.SendMessagePresenter;
import use_case.SendMessage.SendMessageInputBoundary;
import use_case.SendMessage.SendMessageInteractor;
import use_case.SendMessage.SendMessageMainPlayerDataAccessInterface;
import use_case.SendMessage.SendMessageOutputBoundary;
import view.ChatView;

public class ChatUseCaseFactory {
    private ChatUseCaseFactory() {
    }

    public static ChatView create(SendMessageMainPlayerDataAccessInterface mainPlayerDataAccessObject, ChatViewModel chatViewModel, SendMessageLoggerModel sendMessageLoggerModel) {
        SendMessageController sendMessageController = createSendMessageUseCase(mainPlayerDataAccessObject, sendMessageLoggerModel);
        return new ChatView(chatViewModel, sendMessageController);
    }

    private static SendMessageController createSendMessageUseCase(SendMessageMainPlayerDataAccessInterface mainPlayerDataAccessObject, SendMessageLoggerModel sendMessageLoggerModel) {
        SendMessageOutputBoundary sendMessageOutputBoundary = new SendMessagePresenter(sendMessageLoggerModel);
        SendMessageInputBoundary sendMessageInputBoundary = new SendMessageInteractor(mainPlayerDataAccessObject, sendMessageOutputBoundary);
        return new SendMessageController(sendMessageInputBoundary);
    }


}
