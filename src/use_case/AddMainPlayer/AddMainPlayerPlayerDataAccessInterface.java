package use_case.AddMainPlayer;

import entity.Player;

public interface AddMainPlayerPlayerDataAccessInterface {
    boolean existsByName(String identifier);
    void save(Player mainPlayer);
}
