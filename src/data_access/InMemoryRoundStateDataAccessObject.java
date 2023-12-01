package data_access;

import entity.RoundState;
import use_case.CheckGuess.CheckGuessRoundStateDataAccessInterface;
import use_case.ReceiveMessage.ReceiveMessageRoundStateDataAccessInterface;
import use_case.RunGame.RunGameRoundStateDataAccessInterface;
import use_case.SingerChoose.SingerChooseRoundStateDataAccessInterface;
import use_case.UpdateScore.UpdateScoreRoundStateDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRoundStateDataAccessObject implements CheckGuessRoundStateDataAccessInterface, SingerChooseRoundStateDataAccessInterface, ReceiveMessageRoundStateDataAccessInterface, UpdateScoreRoundStateDataAccessInterface, RunGameRoundStateDataAccessInterface {

    private final List<RoundState> rounds = new ArrayList<>();

    public RoundState getCurrentRoundState() {
        return rounds.get(rounds.size() - 1);
    }

    public void addRound() {
        rounds.add(new RoundState());
    }
}
