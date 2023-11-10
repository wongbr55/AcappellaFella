package interface_adapter.SendMessage;


import use_case.SendMessage.SendMessageInputBoundary;
import use_case.SendMessage.SendMessageInputData;

public class SendMessageController {
    final SendMessageInputBoundary sendMessageInteractor;

    public SendMessageController(SendMessageInputBoundary sendMessageInteractor) {
        this.sendMessageInteractor = sendMessageInteractor;
    }

    public void execute(String message) {
        SendMessageInputData sendMessageInputData = new SendMessageInputData(message);
        sendMessageInteractor.execute(sendMessageInputData);
    }
}
