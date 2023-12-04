package use_case.StartLobby;

import entity.Player;

public interface StartLobbyDataAccessInterface {
    boolean existsByName(String identifier);

    void save(Player player);
}
