package interface_adapter.Chat;

public class ChatState {
    private String messageHistory = "";
    private String typingContent = "";

    public String getTypingContent() {
        return typingContent;
    }
    public void setTypingContent(String typingContent) {
        this.typingContent = typingContent;
    }

    public String getMessageHistory() {
        return messageHistory;
    }

    public void setMessageHistory(String messageHistory) {
        this.messageHistory = messageHistory;
    }
}
