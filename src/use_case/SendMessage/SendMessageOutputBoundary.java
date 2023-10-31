package use_case.SendMessage;

import chat.MessageLogger;

public interface SendMessageOutputBoundary {
    void prepareSuccessView(SendMessageOutputData sendMessageOutputData);
    void prepareFailView(String error);
}
