package use_case.SingerChoose;

import entity.Song;

public class SingerChooseInputData {
    final private Song song;

    public SingerChooseInputData(Song song) {
        this.song = song;
    }

    public Song getSong() {
        return song;
    }
}
