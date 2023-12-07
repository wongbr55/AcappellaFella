package interface_adapter.WaitRoom;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WaitRoomStateTest {

    private WaitRoomState waitRoomState;
    @Before
    public void setUp() {
        waitRoomState = new WaitRoomState();
    }

    @Test
    public void getPlaylistLink() {
        assertEquals(null, waitRoomState.getPlaylistError());
    }

    @Test
    public void setPlaylistLink() {
        waitRoomState.setPlaylistLink("hehehehe");
        assertEquals("hehehehe", waitRoomState.getPlaylistLink());
    }

    @Test
    public void getNumberOfRounds() {
        assertEquals(3, waitRoomState.getNumberOfRounds());
    }

    @Test
    public void setNumberOfRounds() {
        waitRoomState.setNumberOfRounds(2);
        assertEquals(2, waitRoomState.getNumberOfRounds());

    }

    @Test
    public void getRoundLength() {
        assertEquals(30, waitRoomState.getRoundLength());
    }

    @Test
    public void setRoundLength() {
        waitRoomState.setRoundLength(2);
        assertEquals(2, waitRoomState.getRoundLength());

    }

    @Test
    public void getLobbyID() {
        assertEquals("", waitRoomState.getLobbyID());
    }

    @Test
    public void setLobbyID() {
        waitRoomState.setLobbyID("hehe");
        assertEquals("hehe", waitRoomState.getLobbyID());
    }

    @Test
    public void isPlaylistLoaded() {
        assertFalse(waitRoomState.isPlaylistLoaded());
    }

    @Test
    public void setPlaylistLoaded() {
        waitRoomState.setPlaylistLoaded(true);
        assertTrue(waitRoomState.isPlaylistLoaded());
    }

    @Test
    public void getPlaylistError() {
        assertEquals(null, waitRoomState.getPlaylistError());
    }

    @Test
    public void setPlaylistError() {
        waitRoomState.setPlaylistError("hehe");
        assertEquals("hehe", waitRoomState.getPlaylistError());


    }
}