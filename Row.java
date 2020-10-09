import java.util.ArrayList;

public class Row {

    private int rowNumber;
    private ArrayList<Space> rowSpaces = new ArrayList<Space>();

    // Constructor
    public Row(int rowNumber) {
        this.rowNumber = rowNumber;
    }


    // Getters and Setters
    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }
}
