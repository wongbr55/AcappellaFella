package app;

import interface_adapter.Chat.ChatViewModel;
import interface_adapter.CheckGuess.CheckGuessController;
import interface_adapter.PlayerGuess.PlayerGuessViewModel;
import interface_adapter.SendMessage.SendMessageController;
import interface_adapter.SendMessage.SendMessageLoggerModel;
import interface_adapter.SendMessage.SendMessagePresenter;
import use_case.CheckGuess.CheckGuessGameStateDataAccessInterface;
import use_case.CheckGuess.CheckGuessInteractor;
import use_case.CheckGuess.CheckGuessRoundStateDataAccessInterface;
import use_case.SendMessage.SendMessageInputBoundary;
import use_case.SendMessage.SendMessageInteractor;
import use_case.SendMessage.SendMessageMainPlayerDataAccessInterface;
import use_case.SendMessage.SendMessageOutputBoundary;
import view.ChatView;

public class ChatUseCaseFactory {
    private ChatUseCaseFactory() {
    }

    public static ChatView create(SendMessageMainPlayerDataAccessInterface mainPlayerDataAccessObject, ChatViewModel chatViewModel, SendMessageLoggerModel sendMessageLoggerModel, PlayerGuessViewModel playerGuessViewModel, CheckGuessGameStateDataAccessInterface checkGuessGameStateDataAccessInterface, CheckGuessRoundStateDataAccessInterface checkGuessRoundStateDataAccessInterface) {
        SendMessageInteractor sendMessageInteractor = createSendMessageInteractor(mainPlayerDataAccessObject, sendMessageLoggerModel);
        CheckGuessController checkGuessController = createCheckGuessController(sendMessageInteractor, checkGuessGameStateDataAccessInterface, checkGuessRoundStateDataAccessInterface);
        SendMessageController sendMessageController = createSendMessageController(sendMessageInteractor);
        return new ChatView(chatViewModel, sendMessageController, checkGuessController);
    }

    private static SendMessageInteractor createSendMessageInteractor(SendMessageMainPlayerDataAccessInterface mainPlayerDataAccessObject, SendMessageLoggerModel sendMessageLoggerModel) {
        SendMessageOutputBoundary sendMessageOutputBoundary = new SendMessagePresenter(sendMessageLoggerModel);

        return new SendMessageInteractor(mainPlayerDataAccessObject, sendMessageOutputBoundary);
    }

    private static SendMessageController createSendMessageController(SendMessageInteractor sendMessageInteractor) {
        return new SendMessageController(sendMessageInteractor);
    }

    private static CheckGuessController createCheckGuessController(SendMessageInputBoundary sendMessageInputBoundary, CheckGuessGameStateDataAccessInterface checkGuessGameStateDataAccessInterface, CheckGuessRoundStateDataAccessInterface checkGuessRoundStateDataAccessInterface) {
        CheckGuessInteractor checkGuessInteractor = new CheckGuessInteractor(checkGuessGameStateDataAccessInterface, checkGuessRoundStateDataAccessInterface, sendMessageInputBoundary);
        return new CheckGuessController(checkGuessInteractor);
    }

}
