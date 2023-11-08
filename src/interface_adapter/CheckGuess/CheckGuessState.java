package interface_adapter.CheckGuess;

public class CheckGuessState {
    private String titleLabel = "Guess the Song!";
    private boolean hasGuessed = false;

    public CheckGuessState() {
    }

    public String getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(String title_label) {
        this.titleLabel = title_label;
    }

    public void setHasGuessed(boolean hasGuessed) {
        this.hasGuessed = hasGuessed;
    }
    public boolean getHasGuessed(){
        return this.hasGuessed;
    }
}
