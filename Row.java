import java.util.ArrayList;

public class Row {

    private ArrayList<Space> rowSpaces = new ArrayList<Space>(); // ArrayList of spaces in the row

    // Constructor which adds rowSpaces to the Row equal to NUMOFCOLUMNS variable
    public Row(int NUMOFCOLUMNS) {
        for (int i = 0; i < NUMOFCOLUMNS+1; i++) {
            Space tempSpace = new Space(true);
            this.rowSpaces.add(tempSpace);
        }
    }

    // Getter for list of spaces in a row
    public ArrayList<Space> getRowSpaces() {
        return rowSpaces;
    }

}
