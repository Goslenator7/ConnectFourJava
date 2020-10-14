import javax.swing.*;
import java.util.ArrayList;

public class GameBoard {

    private String name;
    private final int NUMOFROWS = 7;
    private final int NUMOFCOLUMNS = 6;
    // Generate arraylists with the num of rows and columns from method
    private ArrayList<Row> rows = new ArrayList<Row>();
    private ArrayList<Column> columns = new ArrayList<Column>();


    //Constructor
    public GameBoard(String name) {
        this.name = name;
    }

    /* Ask the user for the number of columns they would like and set it
    public void columnDimensions() {
        int numOfColumns;

        numOfColumns = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of columns you want on the board: "));
        setNumOfColumns(numOfColumns);
    }*/

    /*// Ask the user for the number of rows they would like and use set method to set it
    public void rowDimensions() {
        int numOfRows;

        numOfRows = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of rows you want on the board: "));
        setNumOfRows(numOfRows);
    }*/

    // Add a row to the rows array list
    public void addRows(Row row) {
        this.rows.add(row);
    }

    // Add a column to the columns array list
    public void addColumns(Column column) {
        this.columns.add(column);
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Get the number of rows
    public int getNumOfRows() {
        return this.NUMOFROWS;
    }

    // Get the number of columns
    public int getNumOfColumns() {
        return this.NUMOFCOLUMNS;
    }

}
