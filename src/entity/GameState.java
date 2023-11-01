package entity;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    private String id;
    private Song song;
    private final List<Player> players = new ArrayList<>();
    private Player mainPlayer;
    public Song getSong() {
        return this.song;
    }
    public void setSong(Song song) {
        this.song = song;
    }
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
