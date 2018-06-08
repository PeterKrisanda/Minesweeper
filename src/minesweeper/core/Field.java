package minesweeper.core;

import java.util.Random;

/**
 * Field represents playing field and game logic.
 */
public class Field {
    /** Playing field tiles. */
    private final Tile[][] tiles;

    /** Field row count. Rows are indexed from 0 to (rowCount - 1). */
    private final int rowCount;

    /** Column count. Columns are indexed from 0 to (columnCount - 1). */
    private final int columnCount;

    /** Mine count. */
    private final int mineCount;

    /** Game state. */
    private GameState state = GameState.PLAYING;

    /**
     * Constructor.
     * @param rowCount row count
     * @param columnCount column count
     * @param mineCount mine count
     */
    public Field(int rowCount, int columnCount, int mineCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.mineCount = mineCount;
        tiles = new Tile[rowCount][columnCount];
        generate();
    }

    /**
     * Opens tile at specified indeces.
     * @param row row number
     * @param column column number
     */
    public void openTile(int row, int column) {
        final Tile tile = tiles[row][column];
        if(tile.getState() == Tile.State.CLOSED) {
            tile.setState(Tile.State.OPEN);
            if(tile instanceof Mine) {
                state = GameState.FAILED;
                return;
            }
            if(tile instanceof Clue){
                Clue clue=(Clue)tile;
                if(clue.getValue()==0)
                    this.openAdjacentTiles(row, column);
                }

            if(isSolved()) {
                state = GameState.SOLVED;
            }
        }
    }
    
    private void openAdjacentTiles(int row, int column){
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(row-1+i>=0&&row-1+i<rowCount&&column-1+j>=0&&column-1+j<columnCount){
                    this.openTile(row-1+i,column-1+j);
                }
            }
        }
    }

    /**
     * Marks tile at specified indeces.
     * @param row row number
     * @param column column number
     */
    public void markTile(int row, int column) {

        Tile tile = getTile(row,column);
        Tile.State tileState = tile.getState();
        if (tileState == Tile.State.CLOSED) {
            tile.setState(Tile.State.MARKED);
        }else
        if (tileState == Tile.State.MARKED) {
            tile.setState(Tile.State.CLOSED);
        }
    }

    /**
     * Generates playing field.
     */
    private void generate() {
        generateMines();
        fillWithClues();
    }

    private void generateMines(){
        Random randomn = new Random();
        int help = 0;
        while(help<mineCount){
            int x = randomn.nextInt(rowCount);
            int y = randomn.nextInt(columnCount);
            if (tiles[x][y] == null){
                tiles[x][y] = new Mine();
                help++;
            }
        }
    }
    
    private void fillWithClues(){
        for (int i = 0; i < rowCount ; i++){
            for (int j = 0; j < columnCount; j++){
                if (tiles[i][j] == null){
                    tiles[i][j] = new Clue(countAdjacentMines(i,j));
                }
            }
        }
    }
    
    /**
     * Returns true if game is solved, false otherwise.
     * @return true if game is solved, false otherwise
     */
    private boolean isSolved() {
        int allTiles = (this.getNumberOf(Tile.State.OPEN) + this.getNumberOf(Tile.State.CLOSED) 
                        + this.getNumberOf(Tile.State.MARKED));
        int openTiles = this.getNumberOf(Tile.State.OPEN);
        int playerTiles = allTiles - openTiles;
        return playerTiles == this.mineCount;
      
    }
    
    public int getNumberOf(Tile.State state){
        int countInState = 0;
        for(int i = 0; i < this.getRowCount(); i++){
            for(int j = 0; j < this.getColumnCount(); j++){
                if(state == tiles[i][j].getState()){
                    countInState++;
                }
            }
        }
        return countInState;
    }
    
    public int getRemainingMineCount(){
        int mineCount = getMineCount();
        int markedCount = getNumberOf(Tile.State.MARKED);       
        return mineCount - markedCount;
    }

    /**
     * Returns number of adjacent mines for a tile at specified position in the field.
     * @param row row number.
     * @param column column number.
     * @return number of adjacent mines.
     */
    private int countAdjacentMines(int row, int column) {
		int count = 0;

        for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {
            int actRow = row + rowOffset;
            if (actRow >= 0 && actRow < getRowCount()) {
                for (int columnOffset = -1; columnOffset <= 1; columnOffset++) {
                    int actColumn = column + columnOffset;
                    if (actColumn >= 0 && actColumn < getColumnCount()) {
                        if (tiles[actRow][actColumn] instanceof Mine) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
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

    /**
     * @return the state
     */
    public GameState getState() {
        return state;
    }

    public Tile getTile(int row,int column){
        return this.tiles[row][column];
    }
    
}
