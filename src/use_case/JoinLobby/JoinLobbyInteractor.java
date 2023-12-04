package use_case.JoinLobby;

public class JoinLobbyInteractor implements JoinLobbyInputBoundary {
    final JoinLobbyOutputBoundary joinLobbyPresenter;

    public JoinLobbyInteractor(JoinLobbyOutputBoundary joinLobbyOutputBoundary){
        this.joinLobbyPresenter = joinLobbyOutputBoundary;
    }

    public void execute(JoinLobbyInputData joinLobbyInputData){
        JoinLobbyOutputData outputData = new JoinLobbyOutputData(joinLobbyInputData.getLobbyID());
        joinLobbyPresenter.prepareSuccessView(outputData);
    }
}
