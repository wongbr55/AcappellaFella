package app;

import interface_adapter.AddMainPlayer.AddMainPlayerController;
import interface_adapter.AddMainPlayer.AddMainPlayerLoggerModel;
import interface_adapter.AddMainPlayer.AddMainPlayerPresenter;
import interface_adapter.ChooseName.HostChooseNameViewModel;
import interface_adapter.ChooseName.JoinChooseNameViewModel;
import interface_adapter.EnterWaitRoom.HostEnterWaitRoom.HostEnterWaitRoomController;
import interface_adapter.EnterWaitRoom.HostEnterWaitRoom.HostEnterWaitRoomPresenter;
import interface_adapter.EnterWaitRoom.JoinEnterWaitRoom.JoinEnterWaitRoomController;
import interface_adapter.EnterWaitRoom.JoinEnterWaitRoom.JoinEnterWaitRoomPresenter;
import interface_adapter.Scoreboard.ScoreboardViewModel;
import interface_adapter.SendMessage.SendMessageLoggerModel;
import interface_adapter.SendMessage.SendMessagePresenter;
import interface_adapter.ViewManagerModel;
import interface_adapter.WaitRoom.HostWaitRoomViewModel;
import interface_adapter.WaitRoom.JoinWaitRoomViewModel;
import use_case.AddMainPlayer.*;
import use_case.EnterWaitRoom.HostEnterWaitRoom.HostEnterWaitRoomInputBoundary;
import use_case.EnterWaitRoom.HostEnterWaitRoom.HostEnterWaitRoomInteractor;
import use_case.EnterWaitRoom.HostEnterWaitRoom.HostEnterWaitRoomOutputBoundary;
import use_case.EnterWaitRoom.JoinEnterWaitRoom.JoinEnterWaitRoomInputBoundary;
import use_case.EnterWaitRoom.JoinEnterWaitRoom.JoinEnterWaitRoomInteractor;
import use_case.EnterWaitRoom.JoinEnterWaitRoom.JoinEnterWaitRoomOutputBoundary;
import use_case.SendMessage.SendMessageInputBoundary;
import use_case.SendMessage.SendMessageInteractor;
import use_case.SendMessage.SendMessageMainPlayerDataAccessInterface;
import use_case.SendMessage.SendMessageOutputBoundary;
import view.HostChooseNameView;
import view.JoinChooseNameView;

public class ChooseNameViewFactory {
    private ChooseNameViewFactory() {
    }

    public static JoinChooseNameView createJoinView(HostWaitRoomViewModel hostWaitRoomViewModel,
                                                    JoinWaitRoomViewModel joinWaitRoomViewModel,
                                                    HostChooseNameViewModel hostChooseNameViewModel,
                                                    JoinChooseNameViewModel joinChooseNameViewModel,
                                                    ScoreboardViewModel scoreboardViewModel,
                                                    ViewManagerModel viewManagerModel,
                                                    AddMainPlayerLoggerModel addMainPlayerLoggerModel,
                                                    SendMessageLoggerModel sendMessageLoggerModel,
                                                    AddMainPlayerPlayerDataAccessInterface mainPlayerDAO,
                                                    AddMainPlayerScoreboardDataAccessInterface scoreboardDAO,
                                                    AddMainPlayerGameStateDataAccessInterface gameStateDAO,
                                                    SendMessageMainPlayerDataAccessInterface sendMessageMainPlayerDataAccessInterface) {
        HostEnterWaitRoomController hostEnterWaitRoomController = createHostEnterWaitRoomUseCase(hostWaitRoomViewModel, hostChooseNameViewModel, viewManagerModel);
        JoinEnterWaitRoomController joinEnterWaitRoomController = createJoinEnterWaitRoomUseCase(joinWaitRoomViewModel, joinChooseNameViewModel, viewManagerModel);
        AddMainPlayerController addMainPlayerController = createAddMainPlayerUseCase(scoreboardViewModel, joinEnterWaitRoomController, hostEnterWaitRoomController, addMainPlayerLoggerModel, sendMessageLoggerModel, mainPlayerDAO, scoreboardDAO, gameStateDAO, sendMessageMainPlayerDataAccessInterface);
        return new JoinChooseNameView(joinChooseNameViewModel, addMainPlayerController);
    }

    public static HostChooseNameView createHostView(HostWaitRoomViewModel hostWaitRoomViewModel,
                                                    JoinWaitRoomViewModel joinWaitRoomViewModel,
                                                    HostChooseNameViewModel hostChooseNameViewModel,
                                                    JoinChooseNameViewModel joinChooseNameViewModel,
                                                    ScoreboardViewModel scoreboardViewModel,
                                                    ViewManagerModel viewManagerModel,
                                                    AddMainPlayerLoggerModel addMainPlayerLoggerModel,
                                                    SendMessageLoggerModel sendMessageLoggerModel,
                                                    AddMainPlayerPlayerDataAccessInterface mainPlayerDAO,
                                                    AddMainPlayerScoreboardDataAccessInterface scoreboardDAO,
                                                    AddMainPlayerGameStateDataAccessInterface gameStateDAO,
                                                    SendMessageMainPlayerDataAccessInterface sendMessageMainPlayerDataAccessInterface) {
        HostEnterWaitRoomController hostEnterWaitRoomController = createHostEnterWaitRoomUseCase(hostWaitRoomViewModel, hostChooseNameViewModel, viewManagerModel);
        JoinEnterWaitRoomController joinEnterWaitRoomController = createJoinEnterWaitRoomUseCase(joinWaitRoomViewModel, joinChooseNameViewModel, viewManagerModel);
        AddMainPlayerController addMainPlayerController = createAddMainPlayerUseCase(scoreboardViewModel, joinEnterWaitRoomController, hostEnterWaitRoomController, addMainPlayerLoggerModel, sendMessageLoggerModel, mainPlayerDAO, scoreboardDAO, gameStateDAO, sendMessageMainPlayerDataAccessInterface);
        return new HostChooseNameView(hostChooseNameViewModel, addMainPlayerController);
    }

    private static AddMainPlayerController createAddMainPlayerUseCase(ScoreboardViewModel scoreboardViewModel,
                                                                      JoinEnterWaitRoomController joinEnterWaitRoomController,
                                                                      HostEnterWaitRoomController hostEnterWaitRoomController,
                                                                      AddMainPlayerLoggerModel addMainPlayerLoggerModel,
                                                                      SendMessageLoggerModel sendMessageLoggerModel,
                                                                      AddMainPlayerPlayerDataAccessInterface mainPlayerDAO,
                                                                      AddMainPlayerScoreboardDataAccessInterface scoreboardDAO,
                                                                      AddMainPlayerGameStateDataAccessInterface gameStateDAO,
                                                                      SendMessageMainPlayerDataAccessInterface sendMessageMainPlayerDataAccessInterface) {
        SendMessageOutputBoundary sendMessageOutputBoundary = new SendMessagePresenter(sendMessageLoggerModel);
        SendMessageInputBoundary sendMessageInputBoundary = new SendMessageInteractor(sendMessageMainPlayerDataAccessInterface, sendMessageOutputBoundary);
        AddMainPlayerOutputBoundary addMainPlayerPresenter = new AddMainPlayerPresenter(addMainPlayerLoggerModel);
        AddMainPlayerInputBoundary addMainPlayerInputBoundary = new AddMainPlayerInteractor(mainPlayerDAO, scoreboardDAO, gameStateDAO, scoreboardViewModel, sendMessageInputBoundary, joinEnterWaitRoomController, hostEnterWaitRoomController, addMainPlayerPresenter);
        return new AddMainPlayerController(addMainPlayerInputBoundary);
    }

    private static HostEnterWaitRoomController createHostEnterWaitRoomUseCase(HostWaitRoomViewModel hostWaitRoomViewModel, HostChooseNameViewModel hostChooseNameViewModel, ViewManagerModel viewManagerModel) {
        HostEnterWaitRoomOutputBoundary hostEnterWaitRoomPresenter = new HostEnterWaitRoomPresenter(hostWaitRoomViewModel, hostChooseNameViewModel, viewManagerModel);
        HostEnterWaitRoomInputBoundary hostEnterWaitRoomInteractor = new HostEnterWaitRoomInteractor(hostEnterWaitRoomPresenter);
        return new HostEnterWaitRoomController(hostEnterWaitRoomInteractor);
    }

    private static JoinEnterWaitRoomController createJoinEnterWaitRoomUseCase(JoinWaitRoomViewModel joinWaitRoomViewModel, JoinChooseNameViewModel joinChooseNameViewModel, ViewManagerModel viewManagerModel) {
        JoinEnterWaitRoomOutputBoundary joinEnterWaitRoomOutputBoundary = new JoinEnterWaitRoomPresenter(joinWaitRoomViewModel, joinChooseNameViewModel, viewManagerModel);
        JoinEnterWaitRoomInputBoundary joinEnterWaitRoomInputBoundary = new JoinEnterWaitRoomInteractor(joinEnterWaitRoomOutputBoundary);
        return new JoinEnterWaitRoomController(joinEnterWaitRoomInputBoundary);
    }
}
