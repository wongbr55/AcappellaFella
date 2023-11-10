package entity;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    private final List<Player> players = new ArrayList<>();
    private String id;
    private Player mainPlayer;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Player getMainPlayer() {
        return mainPlayer;
    }

    public void setMainPlayer(Player mainPlayer) {
        this.mainPlayer = mainPlayer;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
}
