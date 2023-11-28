package interface_adapter.EndScreen;

public class EndScreenState {
    String firstPlayerName;
    Integer firstScore;

    public EndScreenState(){}

    public void setFirstPlace(String firstPlayer, Integer firstScore){
        this.firstScore = firstScore;
        this.firstPlayerName = firstPlayer;
    }
    public Integer getFirstScore() {
        return firstScore;
    }
    public String getFirstPlayerName() {
        return firstPlayerName;
    }
}
