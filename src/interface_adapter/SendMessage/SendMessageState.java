package interface_adapter.SendMessage;

import entity.Message;

public class SendMessageState {
    private String lastMessage;

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }
}
