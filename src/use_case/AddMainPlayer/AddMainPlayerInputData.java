package use_case.AddMainPlayer;

import entity.Player;

public class AddMainPlayerInputData {
    private final Player mainPlayer;

    public AddMainPlayerInputData(Player mainPlayer) {
        this.mainPlayer = mainPlayer;
    }

    public Player getMainPlayer(){return this.mainPlayer;}
}
