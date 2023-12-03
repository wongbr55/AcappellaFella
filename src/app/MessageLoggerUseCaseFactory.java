package app;

import interface_adapter.AddPlayer.AddPlayerController;
import interface_adapter.Chat.ChatViewModel;
import interface_adapter.ChooseName.ChooseNameViewModel;
import interface_adapter.ChooseName.HostChooseNameViewModel;
import interface_adapter.ChooseName.JoinChooseNameViewModel;
import interface_adapter.EnterChooseName.HostEnterChooseName.HostEnterChooseNameController;
import interface_adapter.EnterChooseName.HostEnterChooseName.HostEnterChooseNamePresenter;
import interface_adapter.EnterChooseName.JoinEnterChooseName.JoinEnterChooseNameController;
import interface_adapter.EnterChooseName.JoinEnterChooseName.JoinEnterChooseNamePresenter;
import interface_adapter.Home.HomeViewModel;
import interface_adapter.InitializePlayers.InitializePlayersController;
import interface_adapter.JoinLobby.JoinLobbyLoggerModel;
import interface_adapter.ReceiveMessage.ReceiveMessageController;
import interface_adapter.ReceiveMessage.ReceiveMessagePresenter;
import interface_adapter.Scoreboard.ScoreboardViewModel;
import interface_adapter.SendMessage.SendMessageLoggerModel;
import interface_adapter.StartLobby.StartLobbyLoggerModel;
import interface_adapter.ViewManagerModel;
import logger.MessageLogger;
import use_case.AddPlayer.*;
import use_case.EnterChooseName.HostEnterChooseName.HostEnterChooseNameInputBoundary;
import use_case.EnterChooseName.HostEnterChooseName.HostEnterChooseNameInteractor;
import use_case.EnterChooseName.HostEnterChooseName.HostEnterChooseNameOutputBoundary;
import use_case.EnterChooseName.JoinEnterChooseName.JoinEnterChooseNameInputBoundary;
import use_case.EnterChooseName.JoinEnterChooseName.JoinEnterChooseNameInteractor;
import use_case.EnterChooseName.JoinEnterChooseName.JoinEnterChooseNameOutputBoundary;
import use_case.InitializePlayers.InitializePlayersInputBoundary;
import use_case.InitializePlayers.InitializePlayersInteractor;
import use_case.ReceiveMessage.*;
import use_case.UpdateScore.UpdateScoreInputBoundary;

public class MessageLoggerUseCaseFactory {
    private MessageLoggerUseCaseFactory() {
    }

    public static MessageLogger create(ReceiveMessageMessageHistoryDataAccessInterface messageHistoryDataAccessObject,
                                       ReceiveMessagePlayerDataAccessInterface playerDataAccessObject,
                                       SendMessageLoggerModel sendMessageLoggerModel,
                                       StartLobbyLoggerModel startLobbyLoggerModel,
                                       JoinLobbyLoggerModel joinLobbyLoggerModel,
                                       ChatViewModel chatViewModel,
                                       HomeViewModel homeViewModel,
                                       HostChooseNameViewModel hostChooseNameViewModel,
                                       JoinChooseNameViewModel joinChooseNameViewModel,
                                       ViewManagerModel viewManagerModel,
                                       ReceiveMessageGameStateDataAccessInterface gameStateDataAccessObject,
                                       ReceiveMessageRoundStateDataAccessInterface roundStataDataAccessObject,
                                       AddPlayerGameStateDataAccessInterface addPlayerGameStateDataAccessInterface,
                                       AddPlayerScoreboardDataAccessInterface addPlayerScoreboardDataAccessInterface,
                                       AddPlayerPlayerDataAccessInterface addPlayerPlayerDataAccessInterface,
                                       ScoreboardViewModel scoreboardViewModel,
                                       UpdateScoreInputBoundary updateScoreInputBoundary) {
        ReceiveMessageController receiveMessageController = createReceiveMessageUseCase(messageHistoryDataAccessObject, playerDataAccessObject, chatViewModel, gameStateDataAccessObject, roundStataDataAccessObject, updateScoreInputBoundary);
        AddPlayerController addPlayerController = createAddPlayerUseCase(addPlayerGameStateDataAccessInterface, addPlayerScoreboardDataAccessInterface, addPlayerPlayerDataAccessInterface, scoreboardViewModel);
        InitializePlayersController initializePlayersController = createInitializePlayersUseCase(addPlayerController);
        HostEnterChooseNameController hostEnterChooseNameController = createHostEnterChooseNameUseCase(hostChooseNameViewModel, viewManagerModel);
        JoinEnterChooseNameController joinEnterChooseNameController = createJoinEnterChooseNameUseCase(joinChooseNameViewModel, homeViewModel, viewManagerModel);
        return new MessageLogger(sendMessageLoggerModel, startLobbyLoggerModel, joinLobbyLoggerModel, initializePlayersController, receiveMessageController, hostEnterChooseNameController, joinEnterChooseNameController);
    }

    private static ReceiveMessageController createReceiveMessageUseCase(ReceiveMessageMessageHistoryDataAccessInterface messageHistoryDataAccessObject,
                                                                        ReceiveMessagePlayerDataAccessInterface playerDataAccessObject,
                                                                        ChatViewModel chatViewModel,
                                                                        ReceiveMessageGameStateDataAccessInterface gameStateDataAccessObject,
                                                                        ReceiveMessageRoundStateDataAccessInterface roundStataDataAccessObject,
                                                                        UpdateScoreInputBoundary updateScoreInputBoundary) {
        ReceiveMessageOutputBoundary receiveMessageOutputBoundary = new ReceiveMessagePresenter(chatViewModel);
        ReceiveMessageInputBoundary receiveMessageInputBoundary = new ReceiveMessageInteractor(gameStateDataAccessObject, roundStataDataAccessObject, messageHistoryDataAccessObject, playerDataAccessObject, receiveMessageOutputBoundary, updateScoreInputBoundary);
        return new ReceiveMessageController(receiveMessageInputBoundary);
    }

    private static InitializePlayersController createInitializePlayersUseCase(AddPlayerController addPlayerController) {
        InitializePlayersInputBoundary initializePlayersInputBoundary = new InitializePlayersInteractor(addPlayerController);
        return new InitializePlayersController(initializePlayersInputBoundary);
    }

    private static AddPlayerController createAddPlayerUseCase(AddPlayerGameStateDataAccessInterface addPlayerGameStateDataAccessInterface,
                                                              AddPlayerScoreboardDataAccessInterface addPlayerScoreboardDataAccessInterface,
                                                              AddPlayerPlayerDataAccessInterface addPlayerPlayerDataAccessInterface,
                                                              ScoreboardViewModel scoreboardViewModel) {
        AddPlayerInputBoundary addPlayerInputBoundary = new AddPlayerInteractor(addPlayerGameStateDataAccessInterface, addPlayerScoreboardDataAccessInterface, addPlayerPlayerDataAccessInterface, scoreboardViewModel);
        return new AddPlayerController(addPlayerInputBoundary);
    }

    private static HostEnterChooseNameController createHostEnterChooseNameUseCase(ChooseNameViewModel chooseNameViewModel, ViewManagerModel viewManagerModel) {
        HostEnterChooseNameOutputBoundary hostEnterChooseNamePresenter = new HostEnterChooseNamePresenter(chooseNameViewModel, viewManagerModel);
        HostEnterChooseNameInputBoundary hostEnterChooseNameInputBoundary = new HostEnterChooseNameInteractor(hostEnterChooseNamePresenter);
        return new HostEnterChooseNameController(hostEnterChooseNameInputBoundary);
    }

    private static JoinEnterChooseNameController createJoinEnterChooseNameUseCase(JoinChooseNameViewModel joinChooseNameViewModel, HomeViewModel homeViewModel, ViewManagerModel viewManagerModel) {
        JoinEnterChooseNameOutputBoundary joinEnterChooseNameOutputBoundary = new JoinEnterChooseNamePresenter(joinChooseNameViewModel, homeViewModel, viewManagerModel);
        JoinEnterChooseNameInputBoundary joinEnterChooseNameInputBoundary = new JoinEnterChooseNameInteractor(joinEnterChooseNameOutputBoundary);
        return new JoinEnterChooseNameController(joinEnterChooseNameInputBoundary);
    }
}
