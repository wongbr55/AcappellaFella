package use_case.UpdateScore;

import entity.Player;

public class UpdateScoreInputData {

    private Player player;
    public UpdateScoreInputData(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }


}
