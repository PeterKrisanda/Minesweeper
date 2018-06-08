package minesweeper;

import java.io.FileNotFoundException;
import java.io.IOException;
import minesweeper.consoleui.ConsoleUI;
import minesweeper.core.Field;
import minesweeper.swingui.SwingUI;

/**
 * Main application class.
 */
public class Minesweeper {
    /** User interface. */
    private UserInterface userInterface;
    private long startMillis;
    private BestTimes bestTimes;
    private static Minesweeper instance;
    private Settings settings;
    private static final String DEFAULT_UI = "swing";
    /**
     * Constructor.
     */
    private Minesweeper(){
         
        setSettings(Settings.load());
        instance = this;
        //UserInterface = new ConsoleUI();
        bestTimes=new BestTimes();
        userInterface=create(DEFAULT_UI);
        
        this.newGame();
        
        //UserInterface.newGameStarted(field);
    }
    
    public void newGame() {
        Field field = new Field(settings.getRowCount(), settings.getColumnCount(), settings.getMineCount());
        startMillis = System.currentTimeMillis();
        userInterface.newGameStarted(field);
    }

    public static Minesweeper getInstance(){
        
        if(instance == null) {
         instance = new Minesweeper();
        }
        return instance;
    }
    /**
     * Main method.
     * @param args arguments
     */
    public static void main(String[] args) {
        new Minesweeper();
    }
    
    private UserInterface create(String name){
        if(name.equals("swing")){
            return new SwingUI();
        }else if(name.equals("console")){
            return new ConsoleUI();
        }else{
            throw new RuntimeException("No valid UI specified");
        }
    }
    
    public int getPlayingSeconds(){
        long actualMillis = System.currentTimeMillis() - this.startMillis;
        //System.out.print("milis: "+actualMillis);
        int seconds = (int) (actualMillis / 1000) % 60 ;
        return seconds;
    }

    /**
     * @return the bestTimes
     */
    public BestTimes getBestTimes() {
        return bestTimes;
    }

    /**
     * @return the settings
     */
    public Settings getSettings() {
        return settings;
    }

    /**
     * @param settings the settings to set
     */
    public void setSettings(Settings settings) {
        this.settings = settings;
        this.settings.save();
    }
    
}
