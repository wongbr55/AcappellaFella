package entity;

import java.util.List;

public class GameState {
    private static GameState instance;
    private String id;
    private Song song;
    private List<Player> players;
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

}
