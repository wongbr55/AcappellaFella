package interface_adapter.SendMessage;


import entity.Message;
import use_case.SendMessage.SendMessageInputBoundary;
import use_case.SendMessage.SendMessageInputData;

public class SendMessageController {
    final SendMessageInputBoundary sendMessageInteractor;

    public SendMessageController(SendMessageInputBoundary sendMessageInteractor) {
        this.sendMessageInteractor = sendMessageInteractor;
    }

    public void execute(Message message) {
        SendMessageInputData sendMessageInputData = new SendMessageInputData(message);
        sendMessageInteractor.execute(sendMessageInputData);
    }
}
