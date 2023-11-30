package use_case.JoinLobby;

import entity.Player;

public interface JoinLobbyDataAccessInterface {
    boolean existsByName(String identifier);

    void save(Player player);
}
