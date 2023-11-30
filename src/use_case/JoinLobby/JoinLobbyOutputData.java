package use_case.JoinLobby;

public class JoinLobbyOutputData {
    private final String name;

    public JoinLobbyOutputData(String name){
        this.name = name;
    }

    public String getName(){return this.name;}
}
