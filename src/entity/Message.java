package entity;

public class Message {
    private Player author;
    private String content;

    public Message(Player author, String content) {
        this.author = author;
        this.content = content;
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
