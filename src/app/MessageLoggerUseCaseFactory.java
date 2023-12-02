package app;

import interface_adapter.Chat.ChatViewModel;
import interface_adapter.ChooseName.ChooseNameViewModel;
import interface_adapter.ChooseName.HostChooseNameViewModel;
import interface_adapter.EnterChooseName.HostEnterChooseName.HostEnterChooseNameController;
import interface_adapter.EnterChooseName.HostEnterChooseName.HostEnterChooseNamePresenter;
import interface_adapter.ReceiveMessage.ReceiveMessageController;
import interface_adapter.ReceiveMessage.ReceiveMessagePresenter;
import interface_adapter.SendMessage.SendMessageLoggerModel;
import interface_adapter.StartLobby.StartLobbyLoggerModel;
import interface_adapter.ViewManagerModel;
import logger.MessageLogger;
import use_case.EnterChooseName.HostEnterChooseName.HostEnterChooseNameInputBoundary;
import use_case.EnterChooseName.HostEnterChooseName.HostEnterChooseNameInteractor;
import use_case.EnterChooseName.HostEnterChooseName.HostEnterChooseNameOutputBoundary;
import use_case.ReceiveMessage.*;
import use_case.UpdateScore.UpdateScoreInputBoundary;

public class MessageLoggerUseCaseFactory {
    private MessageLoggerUseCaseFactory() {
    }

    public static MessageLogger create(ReceiveMessageMessageHistoryDataAccessInterface messageHistoryDataAccessObject,
                                       ReceiveMessagePlayerDataAccessInterface playerDataAccessObject,
                                       SendMessageLoggerModel sendMessageLoggerModel,
                                       StartLobbyLoggerModel startLobbyLoggerModel,
                                       ChatViewModel chatViewModel,
                                       HostChooseNameViewModel hostChooseNameViewModel,
                                       ViewManagerModel viewManagerModel,
                                       ReceiveMessageGameStateDataAccessInterface gameStateDataAccessObject,
                                       ReceiveMessageRoundStateDataAccessInterface roundStataDataAccessObject,
                                       UpdateScoreInputBoundary updateScoreInputBoundary) {
        ReceiveMessageController receiveMessageController = createMessageLoggerUseCase(messageHistoryDataAccessObject, playerDataAccessObject, chatViewModel, gameStateDataAccessObject, roundStataDataAccessObject, updateScoreInputBoundary);
        HostEnterChooseNameController hostEnterChooseNameController = createHostEnterChooseNameUseCase(hostChooseNameViewModel, viewManagerModel);
        return new MessageLogger(sendMessageLoggerModel, startLobbyLoggerModel, receiveMessageController, hostEnterChooseNameController);
    }

    private static ReceiveMessageController createMessageLoggerUseCase(ReceiveMessageMessageHistoryDataAccessInterface messageHistoryDataAccessObject,
                                                                       ReceiveMessagePlayerDataAccessInterface playerDataAccessObject,
                                                                       ChatViewModel chatViewModel,
                                                                       ReceiveMessageGameStateDataAccessInterface gameStateDataAccessObject,
                                                                       ReceiveMessageRoundStateDataAccessInterface roundStataDataAccessObject,
                                                                       UpdateScoreInputBoundary updateScoreInputBoundary) {
        ReceiveMessageOutputBoundary receiveMessageOutputBoundary = new ReceiveMessagePresenter(chatViewModel);
        ReceiveMessageInputBoundary receiveMessageInputBoundary = new ReceiveMessageInteractor(gameStateDataAccessObject, roundStataDataAccessObject, messageHistoryDataAccessObject, playerDataAccessObject, receiveMessageOutputBoundary, updateScoreInputBoundary);
        return new ReceiveMessageController(receiveMessageInputBoundary);
    }

    private static HostEnterChooseNameController createHostEnterChooseNameUseCase(ChooseNameViewModel chooseNameViewModel, ViewManagerModel viewManagerModel) {
        HostEnterChooseNameOutputBoundary hostEnterChooseNamePresenter = new HostEnterChooseNamePresenter(chooseNameViewModel, viewManagerModel);
        HostEnterChooseNameInputBoundary hostEnterChooseNameInputBoundary = new HostEnterChooseNameInteractor(hostEnterChooseNamePresenter);
        return new HostEnterChooseNameController(hostEnterChooseNameInputBoundary);
    }
}
