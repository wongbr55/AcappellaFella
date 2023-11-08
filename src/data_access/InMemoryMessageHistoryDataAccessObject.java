package data_access;

import entity.MessageHistory;
import use_case.ReceiveMessage.ReceiveMessageMessageHistoryDataAccessInterface;
import use_case.SendMessage.SendMessageMessageHistoryDataAccessInterface;

public class InMemoryMessageHistoryDataAccessObject implements
        SendMessageMessageHistoryDataAccessInterface,
        ReceiveMessageMessageHistoryDataAccessInterface {
    private final MessageHistory messageHistory = new MessageHistory();

    @Override
    public MessageHistory getMessageHistory() {
        return messageHistory;
    }
}
