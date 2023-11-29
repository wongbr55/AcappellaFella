package use_case.StartLobby;

public class StartLobbyOutputData {
    private final String name;

    public StartLobbyOutputData(String name){
        this.name = name;
    }

    public String getName(){return this.name;}
}
