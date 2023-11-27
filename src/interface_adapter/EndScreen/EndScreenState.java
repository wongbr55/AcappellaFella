package interface_adapter.EndScreen;

public class EndScreenState {
    String firstPlayer;
    Integer firstScore;

    public EndScreenState(){}

    public void setFirstPlace(String firstPlayer, Integer firstScore){
        this.firstScore = firstScore;
        this.firstPlayer = firstPlayer;
    }
    public Integer getFirstScore() {
        return firstScore;
    }
    public String getFirstPlayer() {
        return firstPlayer;
    }
}
