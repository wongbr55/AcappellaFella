package interface_adapter.ReceiveMessage;

import use_case.ReceiveMessage.ReceiveMessageInputBoundary;
import use_case.ReceiveMessage.ReceiveMessageInputData;

public class ReceiveMessageController {
    final ReceiveMessageInputBoundary receiveMessageInteractor;

    public ReceiveMessageController(ReceiveMessageInputBoundary receiveMessageInteractor) {
        this.receiveMessageInteractor = receiveMessageInteractor;
    }

    public void execute(String content) {
        String[] parts = content.split("\n", 2);
        // split the content into 2 parts, one containing the author and another containing the message content
        ReceiveMessageInputData receiveMessageInputData = new ReceiveMessageInputData(parts[0], parts[1]);

        receiveMessageInteractor.execute(receiveMessageInputData);
    }
}
