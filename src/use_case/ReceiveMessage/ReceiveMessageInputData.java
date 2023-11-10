package use_case.ReceiveMessage;

public class ReceiveMessageInputData {
    final private String author;
    final private String content;
    final private String type;

    public ReceiveMessageInputData(String author, String content, String type) {
        this.author = author;
        this.content = content;
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getType() {
        return type;
    }
}
