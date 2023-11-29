package use_case.StartLobby;

public class StartLobbyInputData {
    final private String name;

    public StartLobbyInputData(String name){
        this.name = name;
    }

    String getName(){return name;}
}
