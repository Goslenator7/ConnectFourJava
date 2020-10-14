import java.util.ArrayList;

public class Row {

    private int rowNumber;
    private ArrayList<Space> rowSpaces = new ArrayList<Space>();

    // Constructor
    public Row(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    // Add space to list of row spaces
    public void addSpace(Space space) {
        this.rowSpaces.add(space);
    }

    // Getters and Setters
    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

//    // Set row to be added to GameBoard list of rows?
//    public void setRowOf(GameBoard rowOf) {
//        this.rowOf = rowOf;
//    }
}
