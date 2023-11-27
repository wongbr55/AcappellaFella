package use_case.AddPlayer;

import entity.Player;

public class AddPlayerInputData {

    private final Player player;

    public AddPlayerInputData(Player player){
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
