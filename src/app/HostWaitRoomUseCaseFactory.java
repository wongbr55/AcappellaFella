package app;

import interface_adapter.LoadPlaylist.LoadPlaylistController;
import interface_adapter.LoadPlaylist.LoadPlaylistPresenter;
import interface_adapter.SendMessage.SendMessageLoggerModel;
import interface_adapter.SendMessage.SendMessagePresenter;
import interface_adapter.StartGame.StartGameController;
import interface_adapter.WaitRoom.HostWaitRoomViewModel;
import use_case.SendMessage.SendMessageInputBoundary;
import use_case.SendMessage.SendMessageInteractor;
import use_case.SendMessage.SendMessageMainPlayerDataAccessInterface;
import use_case.SendMessage.SendMessageOutputBoundary;
import use_case.StartGame.StartGameInputBoundary;
import use_case.StartGame.StartGameInteractor;
import use_case.LoadPlaylist.LoadPlaylistInputBoundary;
import use_case.LoadPlaylist.LoadPlaylistInteractor;
import use_case.LoadPlaylist.LoadPlaylistOutputBoundary;
import use_case.LoadPlaylist.LoadPlaylistPlaylistDataAccessInterface;
import view.HostWaitRoomView;

public class HostWaitRoomUseCaseFactory {
    private HostWaitRoomUseCaseFactory() {
    }

    public static HostWaitRoomView create(HostWaitRoomViewModel hostWaitRoomViewModel, SendMessageLoggerModel sendMessageLoggerModel, SendMessageMainPlayerDataAccessInterface sendMessageMainPlayerDataAccessInterface, LoadPlaylistPlaylistDataAccessInterface loadPlaylistPlaylistDataAccessObject) {
        StartGameController startGameController = createStartGameUseCase(sendMessageLoggerModel, sendMessageMainPlayerDataAccessInterface);
        LoadPlaylistController loadPlaylistController = createLoadPlaylistUseCase(hostWaitRoomViewModel, loadPlaylistPlaylistDataAccessObject);
        return new HostWaitRoomView(hostWaitRoomViewModel, startGameController, loadPlaylistController);
    }

    private static StartGameController createStartGameUseCase(SendMessageLoggerModel sendMessageLoggerModel, SendMessageMainPlayerDataAccessInterface sendMessageMainPlayerDataAccessInterface) {
        SendMessageInputBoundary sendMessageInputBoundary = createSendMessageUseCase(sendMessageMainPlayerDataAccessInterface, sendMessageLoggerModel);
        StartGameInputBoundary startGameInteractor = new StartGameInteractor(sendMessageInputBoundary);
        return new StartGameController(startGameInteractor);
    }

    private static SendMessageInputBoundary createSendMessageUseCase(SendMessageMainPlayerDataAccessInterface mainPlayerDataAccessObject, SendMessageLoggerModel sendMessageLoggerModel) {
        SendMessageOutputBoundary sendMessageOutputBoundary = new SendMessagePresenter(sendMessageLoggerModel);

        return new SendMessageInteractor(mainPlayerDataAccessObject, sendMessageOutputBoundary);
    }

    private static LoadPlaylistController createLoadPlaylistUseCase(HostWaitRoomViewModel hostWaitRoomViewModel, LoadPlaylistPlaylistDataAccessInterface loadPlaylistPlaylistDataAccessObject) {
        LoadPlaylistOutputBoundary loadPlaylistOutputBoundary = new LoadPlaylistPresenter(hostWaitRoomViewModel);
        LoadPlaylistInputBoundary loadPlaylistInputBoundary = new LoadPlaylistInteractor(loadPlaylistPlaylistDataAccessObject, loadPlaylistOutputBoundary);
        return new LoadPlaylistController(loadPlaylistInputBoundary);
    }
}
