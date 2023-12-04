package use_case.EnterChooseName.JoinEnterChooseName;

public class JoinEnterChooseNameOutputData {
    final private String lobbyID;

    public JoinEnterChooseNameOutputData(String lobbyID) {
        this.lobbyID = lobbyID;
    }

    public String getLobbyID() {
        return lobbyID;
    }
}
