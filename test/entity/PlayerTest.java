package entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

    private Player player;
    @Before
    public void init(){
        player = new Player();
        player.setName("John Doe");
    }

    @Test
    public void testTestGetName() {
        Assert.assertEquals("John Doe", this.player.getName());
    }
    @Test
    public void testTestSetName() {
        this.player.setName("Doe John");
        Assert.assertEquals("Doe John", this.player.getName());
    }
    @Test
    public void testCompareTo() {
        Player user1 = new Player();
        user1.setName("Doe John");
        Assert.assertEquals(6, this.player.compareTo(user1));
        Player user2 = new Player();
        user2.setName(this.player.getName());
        Assert.assertEquals(0, this.player.compareTo(user2));
    }
}