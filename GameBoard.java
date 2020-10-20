package ConnectFour;
import javax.swing.*;
import java.util.ArrayList;

public class GameBoard {

    private String name;
    private final int NUMOFROWS = 6;
    private final int NUMOFCOLUMNS = 7;
    private ArrayList<Row> rows = new ArrayList<Row>(); // ArrayList of rows on the GameBoard

    //Constructor for a GameBoard, generates rows based on NUMOFROWS,
    // which in turn generates rowSpaces for each Row equal to NUMOFCOLUMNS
    public GameBoard(int NUMOFROWS, int NUMOFCOLUMNS) {
        for (int i = 0; i < NUMOFROWS; i++) {
            Row tempRow = new Row(NUMOFROWS);
            this.rows.add(tempRow);
        }
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

    public ArrayList<Row> getRows() {
        return rows;
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

}
