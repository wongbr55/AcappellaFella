package app;

import interface_adapter.SendMessage.SendMessageLoggerModel;
import interface_adapter.SendMessage.SendMessagePresenter;
import interface_adapter.StartGame.StartGameController;
import interface_adapter.WaitRoom.WaitRoomViewModel;
import use_case.SendMessage.SendMessageInputBoundary;
import use_case.SendMessage.SendMessageInteractor;
import use_case.SendMessage.SendMessageMainPlayerDataAccessInterface;
import use_case.SendMessage.SendMessageOutputBoundary;
import use_case.StartGame.StartGameInputBoundary;
import use_case.StartGame.StartGameInteractor;
import view.HostWaitRoomView;

public class HostWaitRoomUseCaseFactory {
    private HostWaitRoomUseCaseFactory() {
    }

    public static HostWaitRoomView create(WaitRoomViewModel waitRoomViewModel, SendMessageLoggerModel sendMessageLoggerModel, SendMessageMainPlayerDataAccessInterface sendMessageMainPlayerDataAccessInterface) {
        StartGameController startGameController = createStartGameUseCase(sendMessageLoggerModel, sendMessageMainPlayerDataAccessInterface);
        return new HostWaitRoomView(waitRoomViewModel, startGameController);
    }

    private static StartGameController createStartGameUseCase(SendMessageLoggerModel sendMessageLoggerModel, SendMessageMainPlayerDataAccessInterface sendMessageMainPlayerDataAccessInterface) {
        SendMessageInputBoundary sendMessageInputBoundary = createSendMessageInteractor(sendMessageMainPlayerDataAccessInterface, sendMessageLoggerModel);
        StartGameInputBoundary startGameInteractor = new StartGameInteractor(sendMessageInputBoundary);
        return new StartGameController(startGameInteractor);
    }

    private static SendMessageInteractor createSendMessageInteractor(SendMessageMainPlayerDataAccessInterface mainPlayerDataAccessObject, SendMessageLoggerModel sendMessageLoggerModel) {
        SendMessageOutputBoundary sendMessageOutputBoundary = new SendMessagePresenter(sendMessageLoggerModel);

        return new SendMessageInteractor(mainPlayerDataAccessObject, sendMessageOutputBoundary);
    }
}
