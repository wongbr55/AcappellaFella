package use_case.SingerChoose;

import entity.RoundState;
import entity.Song;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SingerChooseInteractor implements SingerChooseInputBoundary {
    final SingerChooseRoundStateDataAccessInterface singerChooseRoundStateDataAccessObject;
    final SingerChooseOutputBoundary singerChoosePresenter;

    public SingerChooseInteractor(SingerChooseRoundStateDataAccessInterface singerChooseRoundStateDataAccessObject, SingerChooseOutputBoundary singerChoosePresenter) {
        this.singerChooseRoundStateDataAccessObject = singerChooseRoundStateDataAccessObject;
        this.singerChoosePresenter = singerChoosePresenter;
    }

    @Override
    public void execute(SingerChooseInputData singerChooseInputData) {
        String songPatternString = "(.+?) by (.+?)";
        Pattern songPattern = Pattern.compile(songPatternString);
        Matcher songMatcher = songPattern.matcher(singerChooseInputData.getSongName());

        if (songMatcher.matches()) {
            RoundState roundState = singerChooseRoundStateDataAccessObject.getCurrentRoundState();
            roundState.setSong(new Song(songMatcher.group(2), songMatcher.group(1)));
            roundState.setSingerState(RoundState.SingerState.SINGING);
        } else {
            // todo throw an error here i guess, but it won't happen in our current code
        }
    }
}
