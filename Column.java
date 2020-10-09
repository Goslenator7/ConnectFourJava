import java.util.ArrayList;

public class Column {

    private int columnNumber;
    private ArrayList<Space> columnSpaces = new ArrayList<Space>();

    public Column(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    // Getters and Setters
    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }
}
