package interface_adapter.SingerSing;

public class SingerSingState {
    private String songLabel;
    private String time;
    public SingerSingState(){}
    public String getSongLabel() {
        return songLabel;
    }
    public void setSongLabel(String songLabel) {
        this.songLabel = songLabel;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
