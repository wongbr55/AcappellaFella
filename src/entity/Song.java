package entity;

public class Song {
    private String title = "";
    private String artist = "";

    @Override
    public String toString() {
        return title.concat(" by ").concat(artist);
    }
}
