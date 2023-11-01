package use_case.SendMessage;

import entity.Message;
import entity.MessageHistory;

public class SendMessageOutputData {
    private Message message;

    public SendMessageOutputData(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
