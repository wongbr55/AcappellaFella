package use_case.SingerChoose;

public class SingerChooseInputData {
    final private String songName;

    public SingerChooseInputData(String songName) {
        this.songName = songName;
    }

    public String getSongName() {
        return songName;
    }
}
