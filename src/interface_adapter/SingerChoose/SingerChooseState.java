package interface_adapter.SingerChoose;

import entity.Song;

public class SingerChooseState {
    private Song song1;
    private Song song2;
    private Song song3;
    private String time;

    public Song getSong1() {
        return song1;
    }

    public void setSong1(Song song1) {
        this.song1 = song1;
    }

    public Song getSong2() {
        return song2;
    }

    public void setSong2(Song song2) {
        this.song2 = song2;
    }

    public Song getSong3() {
        return song3;
    }

    public void setSong3(Song song3) {
        this.song3 = song3;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
