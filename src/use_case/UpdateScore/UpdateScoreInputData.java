package use_case.UpdateScore;

import entity.Message;

public class UpdateScoreInputData {

    private Message message;
    public UpdateScoreInputData(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return this.message;
    }


}
