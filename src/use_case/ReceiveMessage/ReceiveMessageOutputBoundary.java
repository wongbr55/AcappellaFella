package use_case.ReceiveMessage;

public interface ReceiveMessageOutputBoundary {
    void prepareSuccessView(ReceiveMessageOutputData receiveMessageOutputData);
    void prepareFailView(String error);
}
