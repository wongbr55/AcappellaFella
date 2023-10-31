package use_case.ReceiveMessage;

import entity.Message;
import entity.MessageHistory;

public class ReceiveMessageOutputData {

    private MessageHistory messageHistory;

    public ReceiveMessageOutputData(MessageHistory messageHistory) {
        this.messageHistory = messageHistory;
    }

    public MessageHistory getMessageHistory() {
        return messageHistory;
    }

    public void setMessageHistory(MessageHistory messageHistory) {
        this.messageHistory = messageHistory;
    }
}
