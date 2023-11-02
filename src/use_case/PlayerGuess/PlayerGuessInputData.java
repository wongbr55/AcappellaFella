package use_case.PlayerGuess;

import entity.Song;

public class PlayerGuessInputData {

    private Song song;

    public PlayerGuessInputData(Song song){
        this.song = song;
    }

    public Song getSong(){
        return this.song;
    }

}
