package entity;

public class Message {
    private Player author;
    private String content;
    private MessageType type;

    public Message(Player author, String content, MessageType type) {
        this.author = author;
        this.content = content;
        this.type = type;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public Player getAuthor() {
        return author;
    }

    public void setAuthor(Player author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public enum MessageType {
        SYSTEM,
        INVIS_SYSTEM,
        ALL,
        GUESSED
    }
}
