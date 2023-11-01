package entity;

import java.util.ArrayList;
import java.util.List;

public class MessageHistory {
    private List<Message> history = new ArrayList<>();

    public List<Message> getHistory() {
        return history;
    }

    public void setHistory(List<Message> history) {
        this.history = history;
    }

    public void addMessage(Message message) {
        this.history.add(message);
    }
}
