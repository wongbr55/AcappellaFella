package use_case.PlayerGuess;

public class PlayerGuessInputData {
    private final String song;
    private final String user;

    public PlayerGuessInputData(String song, String user) {
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
