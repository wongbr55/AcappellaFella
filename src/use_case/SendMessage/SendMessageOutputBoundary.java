package use_case.SendMessage;

public interface SendMessageOutputBoundary {
    void prepareSuccessView(SendMessageOutputData sendMessageOutputData);
    void prepareFailView(String error);
}
