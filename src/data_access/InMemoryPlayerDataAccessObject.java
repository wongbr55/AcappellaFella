package data_access;

import entity.Player;
import use_case.ReceiveMessage.ReceiveMessagePlayerDataAccessInterface;
import use_case.RunGame.RunGamePlayerDataAccessInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryPlayerDataAccessObject implements ReceiveMessagePlayerDataAccessInterface, RunGamePlayerDataAccessInterface {

    private final Map<String, Player> players = new HashMap<>();

    // @Override
    public boolean existsByName(String identifier) {
        return players.containsKey(identifier);
    }

    @Override
    public Player getByName(String identifier) {
        return players.get(identifier);
    }
    @Override
    public int numberOfPlayer() {
        return players.size();
    }

    // @Override
    public void save(Player player) {
        players.put(player.getName(), player);
    }

    @Override
    public List<Player> getPlayerList() {
        return players.values().stream().toList();
    }
}
