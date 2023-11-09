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

    // todo this definitely violates srp
    @Override
    public String toString() {
        return String.format("%s\n%s\n%s", getType(), getAuthor().getName(), getContent());
    }
    // todo this definitely violates srp
    public String toDisplayString() {
        return String.format("%s: %s", getAuthor().getName(), getContent());
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
        ALL,
        GUESSED
    }
}
