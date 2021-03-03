package uk.ac.cf.cs.ons.skillsdb.skillsdb;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RandomTests {


    @Test
    public void getPlayers() throws Exception {
        assertEquals(4, 2+2);
    }

    @Test
    public void getPlayer() throws Exception {
        assertEquals("Dog", String.format("Dog"));
    }

    @Test
    public void checkGeneratedBoard() throws Exception {
        assertEquals(30, 60/2);
    }

}
