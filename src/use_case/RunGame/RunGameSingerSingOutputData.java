package use_case.RunGame;

import entity.Song;
import interface_adapter.SingerChoose.SingerChooseState;
import use_case.SingerChoose.SingerChooseOutputData;

public class RunGameSingerSingOutputData {
    private final Song song;

    public RunGameSingerSingOutputData(Song song) {
        this.song = song;
    }

    public Song getSong(){
        return this.song;
    }
}
