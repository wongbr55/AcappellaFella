package app;

import interface_adapter.SendMessage.SendMessageLoggerModel;
import logger.MessageLogger;

public class MessageLoggerUseCaseFactory {
    private MessageLoggerUseCaseFactory() {}

    public static MessageLogger create(SendMessageLoggerModel sendMessageLoggerModel) {
        return new MessageLogger(sendMessageLoggerModel);
    }
}
