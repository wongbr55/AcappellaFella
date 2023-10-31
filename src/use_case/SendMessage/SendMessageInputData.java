package use_case.SendMessage;

import entity.Message;

public class SendMessageInputData {
    final private Message message;

    public SendMessageInputData(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }
}
