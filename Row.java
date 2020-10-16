import java.util.ArrayList;

public class Row {

    private int rowNumber;
    private ArrayList<Space> rowSpaces = new ArrayList<Space>(); // ArrayList of spaces in the row

    // Constructor which adds rowSpaces to Row equal to NUMOFCOLUMNS variable
    public Row(int NUMOFCOLUMNS) {
        for (int i = 0; i < NUMOFCOLUMNS; i++) {
            Space tempSpace = new Space(true);
            this.rowSpaces.add(tempSpace);
        }
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

    public ArrayList<Space> getRowSpaces() {
        return rowSpaces;
    }

//    // Set row to be added to GameBoard list of rows?
//    public void setRowOf(GameBoard rowOf) {
//        this.rowOf = rowOf;
//    }
}
