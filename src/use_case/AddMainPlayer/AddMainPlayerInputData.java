package use_case.AddMainPlayer;

public class AddMainPlayerInputData {
    private final String mainPlayerName;

    public AddMainPlayerInputData(String mainPlayerName) {
        this.mainPlayerName = mainPlayerName;
    }

    public String getMainPlayerName() {
        return mainPlayerName;
    }
}
