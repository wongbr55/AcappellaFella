package entity;

public class GameState {
    private static GameState instance;
    private Song song;
    public static GameState getInstance() {
        if (instance == null) {
            instance = new GameState();
        }
        return instance;
    }
    public Song getSong() {
        return this.song;
    }
    public void setSong(Song song) {
        this.song = song;
    }
}
