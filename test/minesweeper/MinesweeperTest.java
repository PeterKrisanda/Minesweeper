/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Peter
 */
public class MinesweeperTest {
    
    public MinesweeperTest() {
    }

    /**
     * Test of newGame method, of class Minesweeper.
     */
    @Test
    public void testNewGame() {
        System.out.println("newGame");
        Minesweeper instance = null;
        instance.newGame();
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInstance method, of class Minesweeper.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Minesweeper expResult = null;
        Minesweeper result = Minesweeper.getInstance();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Minesweeper.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Minesweeper.main(args);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayingSeconds method, of class Minesweeper.
     */
    @Test
    public void testGetPlayingSeconds() {
        System.out.println("getPlayingSeconds");
        Minesweeper instance = null;
        int expResult = 0;
        int result = instance.getPlayingSeconds();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBestTimes method, of class Minesweeper.
     */
    @Test
    public void testGetBestTimes() {
        System.out.println("getBestTimes");
        Minesweeper instance = null;
        BestTimes expResult = null;
        BestTimes result = instance.getBestTimes();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSettings method, of class Minesweeper.
     */
    @Test
    public void testGetSettings() {
        System.out.println("getSettings");
        Minesweeper instance = null;
        Settings expResult = null;
        Settings result = instance.getSettings();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSettings method, of class Minesweeper.
     */
    @Test
    public void testSetSettings() {
        System.out.println("setSetting");
        Settings setting = null;
        Minesweeper instance = null;
        instance.setSettings(setting);
        fail("The test case is a prototype.");
    }
    
}
