package use_case.CheckGuess;

public class CheckGuessInputData {
    private final String song;
    private final String user;

    public CheckGuessInputData(String song, String user) {
        this.song = song;
        this.user = user;
    }

    public String getSong() {
        return this.song;
    }

    public String getUser() {
        return this.user;
    }

}
