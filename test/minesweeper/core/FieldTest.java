/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.core;

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
public class FieldTest {
    
    public FieldTest() {
    }
    
    static final int ROWS = 9;
    static final int COLUMNS = 9;
    static final int MINES = 10;
    
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
    
    @Test                
    public void isSolved() {
        Field field = new Field(ROWS, COLUMNS, MINES);
        
        assertEquals(GameState.PLAYING, field.getState());
        
        int open = 0;
        for(int row = 0; row < field.getRowCount(); row++) {
            for(int column = 0; column < field.getColumnCount(); column++) {
                if(field.getTile(row, column) instanceof Clue) {
                    field.openTile(row, column);
                    open++;
                }
                if(field.getRowCount() * field.getColumnCount() - open == field.getMineCount()) {
                    assertEquals(GameState.SOLVED, field.getState());
                } else {
                    assertNotSame(GameState.FAILED, field.getState());
                }
            }
        }
        
        assertEquals(GameState.SOLVED, field.getState());
    } 
    
    @Test
    public void generate(){
        Field field = new Field(ROWS, COLUMNS, MINES);
        assertEquals(ROWS, field.getRowCount());
        assertEquals(COLUMNS, field.getColumnCount());
        assertEquals(MINES, field.getMineCount());
        
        for(int row = 0 ; row < field.getRowCount(); row++){
            for(int column = 0 ; column < field.getColumnCount(); column++){
                assertNotNull(field.getTile(row, column));
            }
        }
        int mineCount = 0;
        
        for(int row = 0 ; row < field.getRowCount(); row++){
            for(int column = 0 ; column < field.getColumnCount(); column++){
                if(field.getTile(row, column) instanceof Mine){
                    mineCount++;
                }
            }
        }
        assertEquals(MINES, mineCount);
        
        int clueCount = 0;
        
        for(int row = 0 ; row < field.getRowCount(); row++){
            for(int column = 0 ; column < field.getColumnCount(); column++){
                if(field.getTile(row, column) instanceof Clue){
                    clueCount++;
                }
            }
        }
        
        assertEquals(ROWS * COLUMNS - MINES, clueCount);
        
        
    }

    /**
     * Test of openTile method, of class Field.
     */
    @Test
    public void testOpenTile() {
        System.out.println("openTile");
        int row = 0;
        int column = 0;
        Field instance = null;
        instance.openTile(row, column);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of markTile method, of class Field.
     */
    @Test
    public void testMarkTile() {
        System.out.println("markTile");
        int row = 0;
        int column = 0;
        Field instance = null;
        instance.markTile(row, column);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberOf method, of class Field.
     */
    @Test
    public void testGetNumberOf() {
        System.out.println("getNumberOf");
        Tile.State state = null;
        Field instance = null;
        int expResult = 0;
        int result = instance.getNumberOf(state);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRowCount method, of class Field.
     */
    @Test
    public void testGetRowCount() {
        System.out.println("getRowCount");
        Field instance = null;
        int expResult = 0;
        int result = instance.getRowCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnCount method, of class Field.
     */
    @Test
    public void testGetColumnCount() {
        System.out.println("getColumnCount");
        Field instance = null;
        int expResult = 0;
        int result = instance.getColumnCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMineCount method, of class Field.
     */
    @Test
    public void testGetMineCount() {
        System.out.println("getMineCount");
        Field instance = null;
        int expResult = 0;
        int result = instance.getMineCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getState method, of class Field.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        Field instance = null;
        GameState expResult = null;
        GameState result = instance.getState();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTile method, of class Field.
     */
    @Test
    public void testGetTile() {
        System.out.println("getTile");
        int row = 0;
        int column = 0;
        Field instance = null;
        Tile expResult = null;
        Tile result = instance.getTile(row, column);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
