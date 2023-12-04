package use_case.RunGame;

public class RunGameEndScreenOutputData {

    private String firstName;
    private Integer firstScore;
    public RunGameEndScreenOutputData(String firstName, Integer firstScore){
        this.firstName = firstName;
        this.firstScore = firstScore;
    }
    public Integer getFirstScore() {
        return firstScore;
    }

    public String getFirstName() {
        return firstName;
    }
}
