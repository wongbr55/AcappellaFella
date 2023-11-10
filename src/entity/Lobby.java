package entity;

import java.util.List;

public class Lobby {
    private String lobbyId;
    private List<String> players;

    public void addPlayer(String player) {
        players.add(player);
    }

    public void removePlayer(String player) {
        players.remove(player);
    }
}
