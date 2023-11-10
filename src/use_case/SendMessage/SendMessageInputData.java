package use_case.SendMessage;

import entity.Message;
import entity.Player;

public class SendMessageInputData {
    final private String message;
    private Player author;
    private Message.MessageType type;

    public SendMessageInputData(String message, Player author) {
        this.author = author;
        this.message = message;
        this.type = Message.MessageType.ALL;
    }

    public SendMessageInputData(String message, Player author, Message.MessageType type) {
        this.author = author;
        this.message = message;
        this.type = type;
    }

    public SendMessageInputData(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Player getAuthor() {
        return this.author;
    }

    public Message.MessageType getType() {
        return type;
    }

    public void setType(Message.MessageType type) {
        this.type = type;
    }
}
