package app;

import interface_adapter.Chat.ChatViewModel;
import interface_adapter.CheckGuess.CheckGuessController;
import interface_adapter.CheckGuess.CheckGuessPresenter;
import interface_adapter.CheckGuess.CheckGuessViewModel;
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

    public static ChatView create(SendMessageMainPlayerDataAccessInterface mainPlayerDataAccessObject, ChatViewModel chatViewModel, SendMessageLoggerModel sendMessageLoggerModel,
                                  CheckGuessViewModel checkGuessViewModel, CheckGuessGameStateDataAccessInterface checkGuessGameStateDataAccessInterface, CheckGuessRoundStateDataAccessInterface checkGuessRoundStateDataAccessInterface) {
        SendMessageInteractor sendMessageInteractor = createSendMessageInteractor(mainPlayerDataAccessObject, sendMessageLoggerModel, checkGuessViewModel, checkGuessGameStateDataAccessInterface, chatViewModel);
        CheckGuessController checkGuessController = createCheckGuessController(sendMessageInteractor, checkGuessViewModel, checkGuessGameStateDataAccessInterface, checkGuessRoundStateDataAccessInterface, chatViewModel);
        SendMessageController sendMessageController = createSendMessageController(sendMessageInteractor);
        return new ChatView(chatViewModel, sendMessageController, checkGuessController);
    }

    private static SendMessageInteractor createSendMessageInteractor(SendMessageMainPlayerDataAccessInterface mainPlayerDataAccessObject, SendMessageLoggerModel sendMessageLoggerModel,
                                                                     CheckGuessViewModel checkGuessViewModel, CheckGuessGameStateDataAccessInterface checkGuessGameStateDataAccessInterface, ChatViewModel chatViewModel) {
        SendMessageOutputBoundary sendMessageOutputBoundary = new SendMessagePresenter(sendMessageLoggerModel);

        return new SendMessageInteractor(mainPlayerDataAccessObject, sendMessageOutputBoundary);
    }

    private static SendMessageController createSendMessageController(SendMessageInteractor sendMessageInteractor) {
        return new SendMessageController(sendMessageInteractor);
    }

    private static CheckGuessController createCheckGuessController(SendMessageInputBoundary sendMessageInputBoundary, CheckGuessViewModel checkGuessViewModel, CheckGuessGameStateDataAccessInterface checkGuessGameStateDataAccessInterface, CheckGuessRoundStateDataAccessInterface checkGuessRoundStateDataAccessInterface, ChatViewModel chatViewModel) {
        CheckGuessPresenter checkGuessPresenter = new CheckGuessPresenter(checkGuessViewModel, chatViewModel);
        CheckGuessInteractor checkGuessInteractor = new CheckGuessInteractor(checkGuessGameStateDataAccessInterface, checkGuessRoundStateDataAccessInterface, checkGuessPresenter, sendMessageInputBoundary);
        return new CheckGuessController(checkGuessInteractor);
    }

}
