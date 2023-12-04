package use_case.EnterChooseName.HostEnterChooseName;

public class HostEnterChooseNameInputData {
    private final String lobbyID;

    public HostEnterChooseNameInputData(String lobbyID) {
        this.lobbyID = lobbyID;
    }

    public String getLobbyID() {
        return lobbyID;
    }
}
