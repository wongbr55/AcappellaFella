package use_case.StartGame;

public class StartGameInputData {
    private final Integer numberOfRounds;
    private final Integer roundLength; // seconds
    private final String playlistID;

    public StartGameInputData(Integer numberOfRounds, Integer roundLength, String playlistID) {
        this.numberOfRounds = numberOfRounds;
        this.roundLength = roundLength;
        this.playlistID = playlistID;
    }

    public Integer getNumberOfRounds() {
        return numberOfRounds;
    }

    public Integer getRoundLength() {
        return roundLength;
    }

    public String getPlaylistID() {
        return playlistID;
    }
}
