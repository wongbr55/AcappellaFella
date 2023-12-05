package entity;

public class Playlist {
    private Song songOne;
    private Song songTwo;
    private Song songThree;

    public Song getSongOne() {
        return this.songOne;
    }

    public void setSongOne(Song song) {
        this.songOne = song;
    }

    public Song getSongTwo() {
        return this.songTwo;
    }

    public void setSongTwo(Song song) {
        this.songTwo = song;
    }

    public Song getSongThree() {
        return this.songThree;
    }

    public void setSongThree(Song song) {
        this.songThree = song;
    }
}
