package interface_adapter.StartGame;

import use_case.StartGame.StartGameInputBoundary;
import use_case.StartGame.StartGameInputData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartGameController {
    private final StartGameInputBoundary startGameInteractor;

    public StartGameController(StartGameInputBoundary startGameInteractor) {
        this.startGameInteractor = startGameInteractor;
    }

    public void execute(int numberOfRounds, int roundLength, String playlistLink) {
        String patternString = ".*playlist/(.+?)\\?(.*)";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(playlistLink);
        // this if statement always passes, since we have to load the playlist first
        if (matcher.matches()) {
            String playlistID = matcher.group(1);
            StartGameInputData inputData = new StartGameInputData(numberOfRounds, roundLength, playlistID);
            startGameInteractor.execute(inputData);
        }
    }
}
