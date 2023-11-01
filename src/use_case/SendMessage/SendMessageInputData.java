package use_case.SendMessage;

import entity.Message;

public class SendMessageInputData {
    final private String message;

    public SendMessageInputData(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
