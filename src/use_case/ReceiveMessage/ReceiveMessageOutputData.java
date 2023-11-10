package use_case.ReceiveMessage;

import entity.Message;

public class ReceiveMessageOutputData {
    private Message message;
    private boolean showMessage;

    public ReceiveMessageOutputData(Message message, Boolean showMessage) {
        this.message = message;
        this.showMessage = showMessage;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public boolean isShowMessage() {
        return showMessage;
    }

    public void setShowMessage(boolean showMessage) {
        this.showMessage = showMessage;
    }
}
