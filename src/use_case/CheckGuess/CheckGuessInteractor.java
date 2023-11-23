package use_case.CheckGuess;

import entity.GameState;
import entity.Message;
import entity.RoundState;
import use_case.SendMessage.SendMessageInputBoundary;
import use_case.SendMessage.SendMessageInputData;

public class CheckGuessInteractor implements CheckGuessInputBoundary {
    private final CheckGuessGameStateDataAccessInterface checkGuessGameStateDataAccessInterface;
    private final CheckGuessRoundStateDataAccessInterface checkGuessRoundStateDataAccessInterface;
    private final SendMessageInputBoundary sendMessageInputBoundary;

    public CheckGuessInteractor(CheckGuessGameStateDataAccessInterface checkGuessGameStateDataAccessInterface, CheckGuessRoundStateDataAccessInterface checkGuessRoundStateDataAccessInterface, SendMessageInputBoundary sendMessageInputBoundary) {
        this.checkGuessGameStateDataAccessInterface = checkGuessGameStateDataAccessInterface;
        this.checkGuessRoundStateDataAccessInterface = checkGuessRoundStateDataAccessInterface;
        this.sendMessageInputBoundary = sendMessageInputBoundary;
    }

    @Override
    public void execute(CheckGuessInputData checkGuessInputData) {
        GameState gameState = checkGuessGameStateDataAccessInterface.getGameState();
        RoundState roundState = checkGuessRoundStateDataAccessInterface.getCurrentRoundState();

        String songTitle = roundState.getSong().getTitle();
        String guessTitle = checkGuessInputData.getGuess();

        Boolean guessStatus = roundState.getGuessStatusByPlayer(gameState.getMainPlayer());
        if (guessStatus) {
            // send a message for everyone to see
            String message = checkGuessInputData.getGuess();
            SendMessageInputData sendMessageInputData = new SendMessageInputData(message, gameState.getMainPlayer(), Message.MessageType.GUESSED);
            this.sendMessageInputBoundary.execute(sendMessageInputData);
        } else if (songTitle.equalsIgnoreCase(guessTitle)) {
            // hide your guess, and then send a system message that everyone can see
            String message = gameState.getMainPlayer().getName() + " has guessed the answer!";

            SendMessageInputData sendMessageInputData = new SendMessageInputData(message, null, Message.MessageType.SYSTEM);
            this.sendMessageInputBoundary.execute(sendMessageInputData);
        } else {
            // send a message for everyone to see
            String message = checkGuessInputData.getGuess();
            SendMessageInputData sendMessageInputData = new SendMessageInputData(message, gameState.getMainPlayer());
            this.sendMessageInputBoundary.execute(sendMessageInputData);
        }
    }
}
