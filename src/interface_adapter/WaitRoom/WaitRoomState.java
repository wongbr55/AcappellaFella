package interface_adapter.WaitRoom;

public class WaitRoomState {
    private String playlistLink = "";
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
}
