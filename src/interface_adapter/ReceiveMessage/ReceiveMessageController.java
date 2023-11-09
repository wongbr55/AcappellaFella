package interface_adapter.ReceiveMessage;

import use_case.ReceiveMessage.ReceiveMessageInputBoundary;
import use_case.ReceiveMessage.ReceiveMessageInputData;

public class ReceiveMessageController {
    final ReceiveMessageInputBoundary receiveMessageInteractor;

    public ReceiveMessageController(ReceiveMessageInputBoundary receiveMessageInteractor) {
        this.receiveMessageInteractor = receiveMessageInteractor;
    }

    public void execute(String content) {
        String[] parts = content.split("\n", 3);
        // split the content into 2 parts, one containing the author and another containing the message content
        ReceiveMessageInputData receiveMessageInputData = new ReceiveMessageInputData(parts[1], parts[2], parts[0]);

        receiveMessageInteractor.execute(receiveMessageInputData);
    }
}
