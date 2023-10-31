package use_case.SendMessage;

import entity.Message;
import entity.MessageHistory;

public class SendMessageOutputData {
    private Message message;

    private MessageHistory messageHistory;

    public SendMessageOutputData(Message message, MessageHistory messageHistory) {
        this.message = message;
        this.messageHistory = messageHistory;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public MessageHistory getMessageHistory() {
        return messageHistory;
    }

    public void setMessageHistory(MessageHistory messageHistory) {
        this.messageHistory = messageHistory;
    }
}
