import java.util.ArrayList;

public class Row {

    private int rowNumber;
    private GameBoard rowOf;
    private ArrayList<Space> rowSpaces = new ArrayList<Space>();

    // Constructor
    public Row(int rowNumber) {
        this.rowNumber = rowNumber;
        this.rowSpaces = 
    }


    // Getters and Setters
    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    // Set row to be added to GameBoard list of rows?
    public void setRowOf(GameBoard rowOf) {
        this.rowOf = rowOf;
    }
}
