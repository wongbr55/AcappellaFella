package use_case.StartGame;

import entity.Message;
import interface_adapter.RunGame.RunGameController;
import use_case.SendMessage.SendMessageInputBoundary;
import use_case.SendMessage.SendMessageInputData;

public class StartGameInteractor implements StartGameInputBoundary {
    private final SendMessageInputBoundary sendMessageInputBoundary;

    public StartGameInteractor(SendMessageInputBoundary sendMessageInputBoundary) {
        this.sendMessageInputBoundary = sendMessageInputBoundary;
    }

    @Override
    public void execute(StartGameInputData startGameInputData) {
        // let other clients know to update roundState.singerState
        String content = "GAME STARTED\n" + startGameInputData.getNumberOfRounds() + "\n" + startGameInputData.getRoundLength();

        SendMessageInputData sendMessageInputData = new SendMessageInputData(content, null, Message.MessageType.INVIS_SYSTEM);
        sendMessageInputBoundary.execute(sendMessageInputData);
    }
}
