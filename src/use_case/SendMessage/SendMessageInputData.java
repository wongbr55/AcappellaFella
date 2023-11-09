package use_case.SendMessage;

import entity.Player;

public class SendMessageInputData {
    final private String message;
    private Player author;

    public SendMessageInputData(String message, Player author) {
        this.author = author;
        this.message = message;
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
}
