/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Peter
 */
public class BestTimesTest {
    
    public BestTimesTest() {
    }

    /**
     * Test of iterator method, of class BestTimes.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        BestTimes instance = new BestTimes();
        Iterator<BestTimes.PlayerTime> expResult = null;
        Iterator<BestTimes.PlayerTime> result = instance.iterator();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPlayerTime method, of class BestTimes.
     */
    @Test
    public void testAddPlayerTime() throws Exception {
        System.out.println("addPlayerTime");
        String name = "";
        int time = 0;
        BestTimes instance = new BestTimes();
        instance.addPlayerTime(name, time);
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class BestTimes.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        BestTimes instance = new BestTimes();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of reset method, of class BestTimes.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        BestTimes instance = new BestTimes();
        instance.reset();
        fail("The test case is a prototype.");
    }
    
}
