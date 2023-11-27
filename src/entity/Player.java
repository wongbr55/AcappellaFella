package entity;

public class Player implements Comparable<Player> {
    private String name = "";
    private int score = 0;

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
    public int compareTo(Player otherPlayer) {
        // Compare based on a property, for example, age
        return this.name.compareTo(otherPlayer.name);
    }
}
