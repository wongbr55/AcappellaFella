package use_case.ReceiveMessage;

import entity.Message;

public class ReceiveMessageOutputData {
    private Message message = null;

    public ReceiveMessageOutputData(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
