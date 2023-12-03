package use_case.JoinLobby;

import entity.Player;

public class JoinLobbyInteractor implements JoinLobbyInputBoundary {
    final JoinLobbyDataAccessInterface joinLobbyDataAccessInterface;
    final JoinLobbyOutputBoundary joinLobbyOutputBoundary;

    public JoinLobbyInteractor(JoinLobbyDataAccessInterface joinLobbyDataAccessInterface, JoinLobbyOutputBoundary joinLobbyOutputBoundary){
        this.joinLobbyDataAccessInterface = joinLobbyDataAccessInterface;
        this.joinLobbyOutputBoundary = joinLobbyOutputBoundary;
    }

    public void execute(JoinLobbyInputData joinLobbyInputData){
        if (joinLobbyDataAccessInterface.existsByName(joinLobbyInputData.getName())){
            joinLobbyOutputBoundary.prepareFailView("Name already in use");
        } else {
            Player player = new Player();
            player.setName(joinLobbyInputData.getName());
            joinLobbyDataAccessInterface.save(player);

            JoinLobbyOutputData joinLobbyOutputData = new JoinLobbyOutputData(player.getName());
            joinLobbyOutputBoundary.prepareSuccessView(joinLobbyOutputData);
        }
    }
}
