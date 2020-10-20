import java.util.ArrayList;

public class Row {

    private int rowNumber;
    private ArrayList<Space> rowSpaces = new ArrayList<Space>(); // ArrayList of spaces in the row

    // Constructor which adds rowSpaces to the Row equal to NUMOFCOLUMNS variable
    public Row(int NUMOFCOLUMNS) {
        for (int i = 0; i < NUMOFCOLUMNS+1; i++) {
            Space tempSpace = new Space(true);
            this.rowSpaces.add(tempSpace);
        }
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

}
