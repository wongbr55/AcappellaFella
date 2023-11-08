package entity;

public class Player {
    private String name = "";
    private int score = 0;
    private boolean guessedCorrect = false;
    // this keeps track of whether or not a player has guessed correctly

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void hasGuessedTrue(){
        this.guessedCorrect = true;
    }
    public void resetGuess(){
        this.guessedCorrect = false;
    }
    public boolean guessStatus(){
        return this.guessedCorrect;
    }
}
