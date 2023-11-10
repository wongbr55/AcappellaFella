package interface_adapter.PlayerGuess;

public class PlayerGuessState {
    private String titleLabel = "Guess the Song!";

    public PlayerGuessState() {
    }

    public String getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(String title_label) {
        this.titleLabel = title_label;
    }

}
