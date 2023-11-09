package use_case.CheckGuess;

import entity.GameState;
import use_case.SendMessage.SendMessageInputBoundary;
import use_case.SendMessage.SendMessageInputData;

public class CheckGuessInteractor implements CheckGuessInputBoundary {
    private final CheckGuessDataAccessInterface checkGuessDataAccessInterface;
    private final SendMessageInputBoundary sendMessageInputBoundary;
    private final CheckGuessOutputBoundary checkGuessOutputBoundary;

    public CheckGuessInteractor(CheckGuessDataAccessInterface checkGuessDataAccessInterface, CheckGuessOutputBoundary checkGuessOutputBoundary, SendMessageInputBoundary sendMessageInputBoundary) {
        this.checkGuessDataAccessInterface = checkGuessDataAccessInterface;
        this.checkGuessOutputBoundary = checkGuessOutputBoundary;
        this.sendMessageInputBoundary = sendMessageInputBoundary;
    }


    @Override
    public void execute(CheckGuessInputData checkGuessInputData) {
        GameState state = this.checkGuessDataAccessInterface.getGameState();
        String songTitle = state.getSong().getTitle();
        String guessTitle = checkGuessInputData.getSong();
        if (songTitle.equalsIgnoreCase(guessTitle) && !state.getMainPlayer().guessStatus()) {
            state.getMainPlayer().setScore(state.getMainPlayer().getScore() + 1);
            // the score system needs to be more complicated, this is left here as a placeholder
            state.getMainPlayer().hasGuessedTrue();
            String message = state.getMainPlayer().getName() + " has guessed the answer! They now have "
                    + state.getMainPlayer().getScore() + " point(s)!";
//            CheckGuessOutputData checkGuessOutputData = new CheckGuessOutputData(message);
//            this.checkGuessOutputBoundary.returnGuess(checkGuessOutputData);
            SendMessageInputData sendMessageInputData = new SendMessageInputData(message, state.getAnnouncer());
            this.sendMessageInputBoundary.execute(sendMessageInputData);
        }
        // this is so that if you have already guessed the correct answer, then you cannot type it in the chat
        else if (!songTitle.equalsIgnoreCase(guessTitle) && !state.getMainPlayer().guessStatus() || !songTitle.equalsIgnoreCase(guessTitle) && state.getMainPlayer().guessStatus()) {
            String message = checkGuessInputData.getSong();
            SendMessageInputData sendMessageInputData = new SendMessageInputData(message, state.getMainPlayer());
            this.sendMessageInputBoundary.execute(sendMessageInputData);
        }
    }
}
