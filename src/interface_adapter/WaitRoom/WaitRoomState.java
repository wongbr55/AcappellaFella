package interface_adapter.WaitRoom;

public class WaitRoomState {
    private String lobbyID = "";
    private String playlistLink = "";
    private boolean playlistLoaded = false;
    private String playlistError;
    private int numberOfRounds = 3;
    private int roundLength = 30;

    public String getPlaylistLink() {
        return playlistLink;
    }

    public void setPlaylistLink(String playlistLink) {
        this.playlistLink = playlistLink;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public int getRoundLength() {
        return roundLength;
    }

    public void setRoundLength(int roundLength) {
        this.roundLength = roundLength;
    }

    public String getLobbyID() {
        return lobbyID;
    }

    public void setLobbyID(String lobbyID) {
        this.lobbyID = lobbyID;
    }

    public boolean isPlaylistLoaded() {
        return playlistLoaded;
    }

    public void setPlaylistLoaded(boolean playlistLoaded) {
        this.playlistLoaded = playlistLoaded;
    }

    public String getPlaylistError() {
        return playlistError;
    }

    public void setPlaylistError(String playlistError) {
        this.playlistError = playlistError;
    }
}
