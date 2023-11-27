package use_case.UpdateScore;

import entity.Player;
import entity.Scoreboard;

public class UpdateScoreOutputData {
    private final Player player;
    private final Integer score;

    public UpdateScoreOutputData(Player player, Integer score) {
        this.player = player;
        this.score = score;
    }

    public Player getPlayer() {return this.player;}
    public Integer getScore() {return this.score;}

}
