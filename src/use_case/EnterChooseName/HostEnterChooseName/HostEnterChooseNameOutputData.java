package use_case.EnterChooseName.HostEnterChooseName;

public class HostEnterChooseNameOutputData {
    private final String lobbyID;

    public HostEnterChooseNameOutputData(String lobbyID) {
        this.lobbyID = lobbyID;
    }

    public String getLobbyID() {
        return lobbyID;
    }
}
