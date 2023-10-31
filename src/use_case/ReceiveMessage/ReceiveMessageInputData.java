package use_case.ReceiveMessage;

public class ReceiveMessageInputData {
    final private String author;
    final private String content;

    public ReceiveMessageInputData(String author, String content) {
        this.author = author;
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }
}
