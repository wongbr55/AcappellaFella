package interface_adapter.LoadPlaylist;

import use_case.loadPlaylist.LoadPlaylistInputBoundary;
import use_case.loadPlaylist.LoadPlaylistInputData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoadPlaylistController {
    private final LoadPlaylistInputBoundary loadPlaylistInteractor;

    public LoadPlaylistController(LoadPlaylistInputBoundary loadPlaylistInteractor) {
        this.loadPlaylistInteractor = loadPlaylistInteractor;
    }

    public void execute(String playlistLink) {
        String patternString = ".*playlist/(.+?)\\?(.*)";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(playlistLink);
        if (matcher.matches()) {
            String playlistID = matcher.group(1);
            LoadPlaylistInputData inputData = new LoadPlaylistInputData(playlistID, null);
            loadPlaylistInteractor.execute(inputData);
        } else {
            LoadPlaylistInputData inputData = new LoadPlaylistInputData(null, "bad link");
            loadPlaylistInteractor.execute(inputData);
        }
    }
}
