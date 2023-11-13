package use_case.SingerChoose;

import entity.Song;

public class SingerChooseOutputData {
    private final Song song;

    public SingerChooseOutputData(Song song) {
        this.song = song;
    }

    public Song getSong(){
        return this.song;
    }
}
