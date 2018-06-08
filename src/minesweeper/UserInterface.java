/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import minesweeper.core.Field;

/**
 *
 * @author Peter
 */
public interface UserInterface {

    /**
     * Starts the game.
     * @param field field of mines and clues
     */
    void newGameStarted(Field field);

    /**
     * Updates user interface - prints the field.
     */
    void update();
    
}
