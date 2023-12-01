package entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoundStateTest {

    private RoundState roundState;
    private Player player1;
    private Player player2;
    private Song song;
    @Before
    public void setUp() {
        this.roundState = new RoundState();
        this.player1 = new Player();
        this.player1.setName("player 1");

        this.player2 = new Player();
        this.player2.setName("player 2");

        this.song = new Song("5 Seconds of Summer", "Youngblood");
        this.roundState.setSong(song);
    }

    @Test
    public void getSong() {
        Song gameSong = this.roundState.getSong();
        assertEquals(song.toString(), gameSong.toString());
    }

    @Test
    public void setSong() {
        Song newSong = new Song("All Time Low", "Love Like War");
        this.roundState.setSong(newSong);
        assertEquals(newSong.toString(), this.roundState.getSong().toString());
    }

    @Test
    public void setGuessAndGetGuessStatusByPlayer() {
        this.roundState.setGuessStatusByPlayer(this.player1, true);
        assertEquals(true, this.roundState.getGuessStatusByPlayer(player1));
        assertEquals(false, this.roundState.getGuessStatusByPlayer(player2));
    }

    @Test
    public void getTotalCorrectGuesses() {
        this.roundState.setGuessStatusByPlayer(player1, true);
        assertEquals(1, (int) this.roundState.getTotalCorrectGuesses());
    }
    @Test
    public void getSingerState() {
        assertEquals(RoundState.SingerState.CHOOSING, this.roundState.getSingerState());
    }

    @Test
    public void setSingerState() {
        this.roundState.setSingerState(RoundState.SingerState.SINGING);
        assertEquals(RoundState.SingerState.SINGING, this.roundState.getSingerState());
    }
}