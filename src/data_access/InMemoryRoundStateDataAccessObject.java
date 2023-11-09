package data_access;

import entity.RoundState;
import use_case.CheckGuess.CheckGuessRoundStateDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRoundStateDataAccessObject implements CheckGuessRoundStateDataAccessInterface {
    private final List<RoundState> rounds = new ArrayList<>();

    public RoundState getCurrentRoundState() {
        return rounds.get(rounds.size() - 1);
    }

    public void addRound() {
        rounds.add(new RoundState());
    }
}
