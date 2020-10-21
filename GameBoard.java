import java.util.ArrayList;

public class GameBoard {

    private ArrayList<Row> rows = new ArrayList<Row>(); // ArrayList of rows on the GameBoard

    //Constructor for a GameBoard, generates rows based on NUMOFROWS,
    // which in turn generates rowSpaces for each Row equal to NUMOFCOLUMNS
    public GameBoard(int NUMOFROWS, int NUMOFCOLUMNS) {
        for (int i = 0; i < NUMOFROWS; i++) {
            Row tempRow = new Row(NUMOFROWS);
            this.rows.add(tempRow);
        }
    }

    // Getter for list of rows
    public ArrayList<Row> getRows() {
        return rows;
    }

}
