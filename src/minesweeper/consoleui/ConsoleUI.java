package minesweeper.consoleui;

import minesweeper.UserInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import minesweeper.Minesweeper;
import minesweeper.core.Clue;
import minesweeper.core.Field;
import minesweeper.core.GameState;
import minesweeper.core.Mine;
import minesweeper.core.Tile;

/**
 * Console user interface.
 */
public class ConsoleUI implements UserInterface {
    /** Playing field. */
    private Field field;
    
    /** Input reader. */
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    
    /**
     * Reads line of text from the reader.
     * @return line as a string
     */
    private String readLine() {
        try {
            return input.readLine();
        } catch (IOException e) {
            return null;
        }
    }
    
    /**
     * Starts the game.
     * @param field field of mines and clues
     */
    @Override
    public void newGameStarted(Field field) {
        this.field = field;
        do {
            update();
            processInput();
            if (field.getState() == GameState.SOLVED){
                System.out.print("Game solved!");
                System.exit(0);
            }
            if (field.getState() == GameState.FAILED){
                System.out.print("Game failed!");
                System.exit(0);
            }
            

        } while(true);
    }
    
    /**
     * Updates user interface - prints the field.
     */
    @Override
    public void update() {
        int x = field.getRowCount();
        int y = field.getColumnCount();
        
        System.out.println("Time: "+Minesweeper.getInstance().getPlayingSeconds());
        System.out.print("Not marked mine: "+field.getRemainingMineCount()+"\n");
        System.out.print("  ");
        int k = 0;
        while(k<y){
            System.out.print(k);
            System.out.print(" ");
            k++;
        }
        System.out.print("\n");
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                
                if(j == 0){
                    System.out.printf("%c",(i)+'A');
                }
                if(field.getTile(i, j).getState() == Tile.State.CLOSED){
                    System.out.printf(" -");
                }
                if(field.getTile(i, j).getState() == Tile.State.MARKED){
                    System.out.printf(" M");
                }
                if(field.getTile(i, j).getState() == Tile.State.OPEN &&
                   field.getTile(i, j) instanceof Mine){
                    System.out.printf(" X");
                }
                if(field.getTile(i, j).getState() == Tile.State.OPEN &&
                   field.getTile(i, j) instanceof Clue){
                    System.out.printf(" %d",((Clue)field.getTile(i, j)).getValue() );
                    
                }
            }
            System.out.printf("\n");
        }
    }
    
    
    /**
     * Processes user input.
     * Reads line from console and does the action on a playing field according to input string.
     */
    private void processInput() {
        //throw new UnsupportedOperationException("Method processInput not yet implemented");
        
        System.out.print("Select: X-exit,MA1-mark,OB4-open: ");
        String playerInput = this.readLine();
        try{
            this.handleInput(playerInput);
        }catch(WrongFormatException ex){
            new WrongFormatException(ex.getMessage());
        }
            
    }
    
    private void handleInput(String playerInput) throws WrongFormatException {
        Boolean correctInput = false;
        do{
            String regPattern="([Xx]|(([oOmM])([a-iA-I])([0-8])))";
            Pattern p = Pattern.compile(regPattern);
            Matcher m = p.matcher(playerInput);
            if(playerInput.equalsIgnoreCase("x")){
                correctInput=true;
                System.exit(0);
            }else if(m.matches()){
                correctInput = true;
                int row=m.group(4).charAt(0)-'a';
                if (row<0){
                    row=m.group(4).charAt(0)-'A';
                }
                int column=Integer.parseInt(m.group(5));
                
                if(m.group(3).equalsIgnoreCase("o")){
                    field.openTile(row,column);
                }
                if(m.group(3).equalsIgnoreCase("m")){
                    field.markTile(row, column);
                }
            }else{
                System.out.print("Wrong input!\n");
            }
            
        }while(correctInput == false);
        
    }
}
