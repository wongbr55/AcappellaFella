package entity;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest extends TestCase {

    private Player player;
    @Before
    public void init(){
        player = new Player();
        player.setName("John Doe");
    }


    @Test
    public void testTestGetName() {
    }

    @Test
    public void testTestSetName() {
    }
    @Test
    public void testGetScore() {
    }
    @Test
    public void testSetScore() {
    }
    @Test
    public void testCompareTo() {
    }
}