package use_case.StartGame;

public class StartGameInputData {
    final private Integer numberOfRounds;
    final private Integer roundLength; // seconds

    public StartGameInputData(Integer numberOfRounds, Integer roundLength) {
        this.numberOfRounds = numberOfRounds;
        this.roundLength = roundLength;
    }

    public Integer getNumberOfRounds() {
        return numberOfRounds;
    }

    public Integer getRoundLength() {
        return roundLength;
    }
}
