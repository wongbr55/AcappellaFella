package use_case.LoadPlaylist;

public class LoadPlaylistInputData {
    private final String playlistID;
    private final String playlistError;

    public LoadPlaylistInputData(String playlistID, String playlistError) {
        this.playlistID = playlistID;
        this.playlistError = playlistError;
    }

    public String getPlaylistID() {
        return playlistID;
    }

    public String getPlaylistError() {
        return playlistError;
    }
}
