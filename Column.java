import java.util.ArrayList;

public class Column {

    private int columnNumber;
    private ArrayList<Space> columnSpaces = new ArrayList<Space>();

    // Constructor
    public Column(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    // Add space to list of column spaces
    public void addSpace(Space space) {
        this.columnSpaces.add(space);
    }

    // Getters and Setters
    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }
}
