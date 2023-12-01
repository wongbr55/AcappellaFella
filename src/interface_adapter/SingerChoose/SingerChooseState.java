package interface_adapter.SingerChoose;

public class SingerChooseState {
    private String song1Name;
    private String song2Name;
    private String song3Name;
    private String time;

    public String getSong1Name() {
        return song1Name;
    }

    public void setSong1Name(String song1Name) {
        this.song1Name = song1Name;
    }

    public String getSong2Name() {
        return song2Name;
    }

    public void setSong2Name(String song2Name) {
        this.song2Name = song2Name;
    }

    public String getSong3Name() {
        return song3Name;
    }

    public void setSong3Name(String song3Name) {
        this.song3Name = song3Name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
