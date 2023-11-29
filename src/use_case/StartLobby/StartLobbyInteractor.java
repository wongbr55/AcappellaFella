package use_case.StartLobby;

import entity.Player;

public class StartLobbyInteractor implements StartLobbyOutputBoundary {
    final StartLobbyDataAccessInterface startLobbyDataAccessInterface;
    final StartLobbyOutputBoundary startLobbyOutputBoundary;

    public StartLobbyInteractor(StartLobbyDataAccessInterface startLobbyDataAccessInterface, StartLobbyOutputBoundary startLobbyOutputBoundary){
        this.startLobbyDataAccessInterface = startLobbyDataAccessInterface;
        this.startLobbyOutputBoundary = startLobbyOutputBoundary;
    }

    public void execute(StartLobbyInputData startLobbyInputData){
        if (startLobbyDataAccessInterface.existsByName(startLobbyInputData.getName())){
            startLobbyOutputBoundary.prepareFailView("Name already in use");
        }else {
            Player player = new Player();
            player.setName(startLobbyInputData.getName());
            startLobbyDataAccessInterface.save(player);

            StartLobbyOutputData startLobbyOutputData = new StartLobbyOutputData(player.getName());
            startLobbyOutputBoundary.prepareSuccessView(startLobbyOutputData);
        }
    }

    @Override
    public void prepareSuccessView(StartLobbyOutputData startLobbyOutputData) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
