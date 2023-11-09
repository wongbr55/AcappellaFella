package use_case.ReceiveMessage;

import entity.Message;
import entity.MessageHistory;
import entity.Player;
import use_case.CheckGuess.CheckGuessInputData;
import use_case.CheckGuess.CheckGuessInteractor;

public class ReceiveMessageInteractor implements ReceiveMessageInputBoundary {
    final ReceiveMessageMessageHistoryDataAccessInterface messageHistoryDataAccessObject;
    final ReceiveMessagePlayerDataAccessInterface playerDataAccessObject;
    final ReceiveMessageOutputBoundary receiveMessagePresenter;
//    final CheckGuessInteractor checkGuessInteractor;

    public ReceiveMessageInteractor(ReceiveMessageMessageHistoryDataAccessInterface messageHistoryDataAccessObject, ReceiveMessagePlayerDataAccessInterface playerDataAccessObject,
                                    ReceiveMessageOutputBoundary receiveMessagePresenter) {
        this.messageHistoryDataAccessObject = messageHistoryDataAccessObject;
        this.playerDataAccessObject = playerDataAccessObject;
        this.receiveMessagePresenter = receiveMessagePresenter;
//        this.checkGuessInteractor = checkGuessInteractor;
    }

    @Override
    public void execute(ReceiveMessageInputData receiveMessageInputData) {
        MessageHistory messageHistory = messageHistoryDataAccessObject.getMessageHistory();
        Player player = playerDataAccessObject.getByName(receiveMessageInputData.getAuthor());
        Message message = new Message(player, receiveMessageInputData.getContent());
        // add message to message history
        messageHistory.addMessage(message);
        ReceiveMessageOutputData receiveMessageOutputData = new ReceiveMessageOutputData(message);
        receiveMessagePresenter.prepareSuccessView(receiveMessageOutputData);

//        CheckGuessInputData checkGuessInputData = new CheckGuessInputData(receiveMessageInputData.getContent(), player.getName());
//        this.checkGuessInteractor.execute(checkGuessInputData);
    }
}
