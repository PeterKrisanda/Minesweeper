package minesweeper;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.sort;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import minesweeper.core.Field;

/**
 * Player times.
 */
public class BestTimes implements Iterable<BestTimes.PlayerTime> {
    /** List of best player times. */
    private List<PlayerTime> playerTimes = new ArrayList<PlayerTime>();

    /**
     * Returns an iterator over a set of  best times.
     * @return an iterator
     */
    public Iterator<PlayerTime> iterator() {
        return playerTimes.iterator();
    }

    /**
     * Adds player time to best times.
     * @param name name ot the player
     * @param time player time in seconds
     */
    public void addPlayerTime(String name, int time) {
        PlayerTime plTime = new PlayerTime(name,time);
        this.playerTimes.add(plTime);
        this.insertToDB(plTime);
        Collections.sort(this.playerTimes);
        
    }

    /**
     * Returns a string representation of the object.
     * @return a string representation of the object
     */
    public String toString() {
        Formatter f = new Formatter();
        this.selectFromDB();
        PlayerTime plTime;
        Iterator iterator= this.playerTimes.iterator();
        while(iterator.hasNext()){
            plTime =(PlayerTime) iterator.next();
            f.format("%s %d\n", plTime.getName(),plTime.getTime() );
        }
        return f.toString();
    }
    
    public void reset(){
        this.playerTimes.clear();
    }
    
    private void insertToDB(PlayerTime playerTime){
        try{
            Class.forName(DatabaseSetting.DRIVER_CLASS);
            Connection connection = DriverManager.getConnection(DatabaseSetting.URL, 
                                DatabaseSetting.USER, DatabaseSetting.PASSWORD);
            java.sql.Statement stm = connection.createStatement();
           /* try {
                stm.executeUpdate(DatabaseSetting.QUERY_CREATE_BEST_TIMES);
            } catch (Exception e) {
                 System.out.printf("Exception occured during saving high score to database: " + e.getMessage());
            }*/
            stm.close();
            PreparedStatement pstm = connection.prepareStatement(DatabaseSetting.QUERY_ADD_BEST_TIME);
            pstm.setString(1, playerTime.getName());
            pstm.setInt(2, playerTime.getTime());
            pstm.execute();
            pstm.close();
            connection.close();
        
        }catch(Exception d){
            System.out.printf("Exception occured during saving high score to database: " + d.getMessage());
        }
    }
    
    private void selectFromDB(){
        try{
            Class.forName(DatabaseSetting.DRIVER_CLASS);
            Connection connection = DriverManager.getConnection(DatabaseSetting.URL, 
                                    DatabaseSetting.USER, DatabaseSetting.PASSWORD);
            java.sql.Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(DatabaseSetting.QUERY_SELECT_BEST_TIMES); 
            
            playerTimes.clear();
            
            while(rs.next()) {
                PlayerTime pt = new PlayerTime(rs.getString(1), rs.getInt(2));
                playerTimes.add(pt);          
            }
            stm.close();
            connection.close();
            sort(playerTimes);
            
        }catch(Exception d){
            System.out.printf("Exception occured during saving high score to database: " + d.getMessage());
        }
    }

    /**
     * Player time.
     */
    public static class PlayerTime implements Comparable<PlayerTime> {
        /** Player name. */
        private final String name;

        /** Playing time in seconds. */
        private final int time;

        /**
         * Constructor.
         * @param name player name
         * @param time playing game time in seconds
         */
        public PlayerTime(String name, int time) {
            this.name = name;
            this.time = time;
        }

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @return the time
         */
        public int getTime() {
            return time;
        }

        @Override
        public int compareTo(PlayerTime o) {
            if(this.getTime() == o.getTime()){
                return 0;
            }else if(this.getTime() > o.getTime()){
                return 1;
            }else{
                return -1;
            }
        }
    }
}