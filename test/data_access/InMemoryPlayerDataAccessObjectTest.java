package data_access;

import entity.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class InMemoryPlayerDataAccessObjectTest {

    private InMemoryPlayerDataAccessObject playerDAO;
    @Before
    public void setUp() {
        playerDAO = new InMemoryPlayerDataAccessObject();
        Player player1 = new Player();
        player1.setName("player1");
        playerDAO.save(player1);
    }

    @Test
    public void existsByName() {
        assertTrue(playerDAO.existsByName("player1"));
        assertFalse(playerDAO.existsByName("player2"));
    }

    @Test
    public void getByName() {
        Player playerFound = playerDAO.getByName("player1");
        assertEquals("player1", playerFound.getName());
    }

    @Test
    public void numberOfPlayer() {
        assertEquals(1, playerDAO.numberOfPlayer());
    }

    @Test
    public void save() {
        Player newPlayer = new Player();
        playerDAO.save(newPlayer);
    }

    @Test
    public void getPlayerList() {
        List<Player> players = playerDAO.getPlayerList();

        assertEquals("player1", players.get(0).getName());

    }
}