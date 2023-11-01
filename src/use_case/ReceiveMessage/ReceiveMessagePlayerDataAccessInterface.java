package use_case.ReceiveMessage;

import entity.Player;

public interface ReceiveMessagePlayerDataAccessInterface {
     Player getByName(String identifier);
}
