import javax.swing.*;
import java.util.ArrayList;

public class GameBoard {

    private String name;
    // Generate arraylists with the num of rows and columns from user input
    private ArrayList<Row> rows = new ArrayList<Row>(numOfRows());
    private ArrayList<Column> columns = new ArrayList<Column>(numOfColumns());

    //Constructor
    public GameBoard(String name) {
        this.name = name;
    }

    // Get the number of rows on the game board from the user
    public int numOfRows() {
        int numOfRows;

        numOfRows = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of rows you want on the board: "));
        return numOfRows;
    }

    // Get the number of columns on the game board from the user
    public int numOfColumns() {
        int numOfColumns;

        numOfColumns = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of columns you want on the board: "));
        return numOfColumns;
    }


    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
