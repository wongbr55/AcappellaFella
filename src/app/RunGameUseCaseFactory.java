package app;

import interface_adapter.PlayerGuess.PlayerGuessViewModel;
import interface_adapter.RunGame.RunGameController;
import interface_adapter.RunGame.RunGamePresenter;
import interface_adapter.SendMessage.SendMessageLoggerModel;
import interface_adapter.SendMessage.SendMessagePresenter;
import interface_adapter.SingerChoose.SingerChooseViewModel;
import interface_adapter.SingerSing.SingerSingViewModel;
import interface_adapter.ViewManagerModel;
import use_case.RunGame.*;
import use_case.SendMessage.SendMessageInputBoundary;
import use_case.SendMessage.SendMessageInteractor;
import use_case.SendMessage.SendMessageMainPlayerDataAccessInterface;
import use_case.SendMessage.SendMessageOutputBoundary;

public class RunGameUseCaseFactory {
    private RunGameUseCaseFactory() {
    }

    // todo move later, temp method for testing
    public static RunGameController createRunGameUseCase(RunGameGameStateDataAccessInterface runGameGameStateDataAccessInterface,
                                                         RunGameRoundStateDataAccessInterface runGameRoundStateDataAccessInterface,
                                                         RunGamePlayerDataAccessInterface runGamePlayerDataAccessInterface,
                                                         SendMessageMainPlayerDataAccessInterface mainPlayerDataAccessObject,
                                                         PlayerGuessViewModel playerGuessViewModel,
                                                         SingerChooseViewModel singerChooseViewModel,
                                                         SingerSingViewModel singerSingViewModel,
                                                         SendMessageLoggerModel sendMessageLoggerModel,
                                                         ViewManagerModel viewManagerModel) {
        SendMessageInputBoundary sendMessageInteractor = createSendMessageInteractor(mainPlayerDataAccessObject, sendMessageLoggerModel);

        RunGameOutputBoundary runGamePresenter = new RunGamePresenter(playerGuessViewModel, singerChooseViewModel, singerSingViewModel, viewManagerModel);

        RunGameInputBoundary runGameInputBoundary = new RunGameInteractor(runGameGameStateDataAccessInterface,
                runGameRoundStateDataAccessInterface,
                runGamePlayerDataAccessInterface,
                runGamePresenter,
                sendMessageInteractor);
        return new RunGameController(runGameInputBoundary);
    }

    private static SendMessageInteractor createSendMessageInteractor(SendMessageMainPlayerDataAccessInterface mainPlayerDataAccessObject, SendMessageLoggerModel sendMessageLoggerModel) {
        SendMessageOutputBoundary sendMessageOutputBoundary = new SendMessagePresenter(sendMessageLoggerModel);

        return new SendMessageInteractor(mainPlayerDataAccessObject, sendMessageOutputBoundary);
    }
}
