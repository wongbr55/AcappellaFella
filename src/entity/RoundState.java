package entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RoundState {
    private final Map<Player, Boolean> playerGuessStatus = new HashMap<>();
    private Song song;

    public Song getSong() {
        return this.song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Boolean getGuessStatusByPlayer(Player player) {
        // if the player hasn't been stored in the round yet, default the guess status to false (haven't guessed yet)
        return playerGuessStatus.getOrDefault(player, false);
    }

    public void setGuessStatusByPlayer(Player player, Boolean newStatus) {
        playerGuessStatus.put(player, newStatus);
    }

    public Integer getTotalCorrectGuesses() {
        return Collections.frequency(playerGuessStatus.values(), true);
    }

}
