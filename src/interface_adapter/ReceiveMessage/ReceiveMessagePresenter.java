package interface_adapter.ReceiveMessage;

import entity.MessageHistory;
import use_case.ReceiveMessage.ReceiveMessageOutputBoundary;
import use_case.ReceiveMessage.ReceiveMessageOutputData;

public class ReceiveMessagePresenter implements ReceiveMessageOutputBoundary {
    @Override
    public void prepareSuccessView(ReceiveMessageOutputData receiveMessageOutputData) {
        MessageHistory messageHistory = receiveMessageOutputData.getMessageHistory();
        // todo update text messges view
    }

    @Override
    public void prepareFailView(String error) {
        // todo
    }
}
