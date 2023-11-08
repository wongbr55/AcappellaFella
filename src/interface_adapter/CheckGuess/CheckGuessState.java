package interface_adapter.CheckGuess;

public class CheckGuessState {
    private String titleLabel = "Guess the Song!";

    public CheckGuessState() {
    }

    public String getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(String title_label) {
        this.titleLabel = title_label;
    }
}
