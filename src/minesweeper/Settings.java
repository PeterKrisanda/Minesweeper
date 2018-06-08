/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Peter
 */
public class Settings implements Serializable {
    private final int rowCount;
    private final int columnCount; 
    private final int mineCount;
    
    public static final Settings BEGINNER = new Settings(9, 9, 3);
    public static final Settings INTERMEDIATE = new Settings(16, 16, 40);
    public static final Settings EXPERT = new Settings(16, 30, 99);
    
    private static final String SETTING_FILE = System.getProperty("user.home") + System.getProperty("file.separator") + "minesweeper.settings";
    
    public Settings(int rowCount, int columnCount, int mineCount){
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.mineCount = mineCount;
    }
    
    @Override
    public boolean equals(Object o){
        Settings playerSettings = (Settings)o;
        if(playerSettings.rowCount == this.rowCount && playerSettings.columnCount == this.columnCount 
           && playerSettings.mineCount == this.mineCount){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public int hashCode(){
        return this.rowCount*this.columnCount*this.mineCount;
    }
    
    public void save() {
        File file = new File(SETTING_FILE);
        try{
        FileOutputStream fout = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(this);
        oos.close();
        } catch(IOException iOException){
        }
    }
    
    public static Settings load(){
        Settings objectRead = null;
        File file = new File(SETTING_FILE);
        try{
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        objectRead = (Settings)ois.readObject();
        } catch (IOException iOException) {
        }catch (ClassNotFoundException classNotFoundException) {
        }
        if(objectRead != null){
            return objectRead;
        }else{
            return BEGINNER;
        }
    }

    /**
     * @return the rowCount
     */
    public int getRowCount() {
        return rowCount;
    }

    /**
     * @return the columnCount
     */
    public int getColumnCount() {
        return columnCount;
    }

    /**
     * @return the mineCount
     */
    public int getMineCount() {
        return mineCount;
    }
}
