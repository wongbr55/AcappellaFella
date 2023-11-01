package entity;

public class Message {
    private Player author;
    private String content;

    public Message(Player author, String content) {
        this.author = author;
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format("%s\n%s", getAuthor().getName(), getContent());
    }

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
}
