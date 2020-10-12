import javax.swing.*;
import java.util.ArrayList;

public class GameBoard {

    private String name;
    private int numOfRows;
    private int numOfColumns;
    // Generate arraylists with the num of rows and columns from method
    private ArrayList<Row> rows = new ArrayList<Row>();
    private ArrayList<Column> columns = new ArrayList<Column>();


    //Constructor
    public GameBoard(String name) {
        this.name = name;
    }

    // Ask the user for the number of columns they would like
    public int columnDimensions() {
        int numOfColumns;

        numOfColumns = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of columns you want on the board: "));
        return numOfColumns;
    }

    // Ask the user for the number of rows they would like
    public int rowDimensions() {
        int numOfRows;

        numOfRows = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of rows you want on the board: "));
        return numOfRows;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Get the number of rows from rowDimensions() input
    public int getNumOfRows() {
        return this.numOfRows;
    }

    // Set the numOfRows equal to rowDimensions() input
    public void setNumOfRows(int numOfRows) {
        this.numOfRows = numOfRows;
    }

    public int getNumOfColumns() {
        return this.numOfColumns;
    }

    public void setNumOfColumns(int numOfColumns) {
        this.numOfColumns = numOfColumns;
    }

}
