/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Peter
 */
public class SettingsTest {
    
   
    
    public SettingsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of equals method, of class Settings.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Settings instance = null;
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Settings.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Settings instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class Settings.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Settings instance = null;
        instance.save();
        fail("The test case is a prototype.");
    }

    /**
     * Test of load method, of class Settings.
     */
    @Test
    public void testLoad() {
        System.out.println("load");
        Settings expResult = null;
        Settings result = Settings.load();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
        
    }

    /**
     * Test of getRowCount method, of class Settings.
     */
    @Test
    public void testGetRowCount() {
        System.out.println("getRowCount");
        Settings instance = null;
        int expResult = 0;
        int result = instance.getRowCount();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnCount method, of class Settings.
     */
    @Test
    public void testGetColumnCount() {
        System.out.println("getColumnCount");
        Settings instance = null;
        int expResult = 0;
        int result = instance.getColumnCount();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMineCount method, of class Settings.
     */
    @Test
    public void testGetMineCount() {
        System.out.println("getMineCount");
        Settings instance = null;
        int expResult = 0;
        int result = instance.getMineCount();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
