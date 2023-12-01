package use_case.RunGame;

public class RunGameInputData {
    final private Integer numberOfRounds;
    final private Integer roundLength; // seconds

    public RunGameInputData(Integer numberOfRounds, Integer roundLength) {
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
