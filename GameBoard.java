import java.util.ArrayList;

public class GameBoard {

    private String name;
    private ArrayList<Row> rows = new ArrayList<Row>();
    private ArrayList<Column> columns = new ArrayList<Column>();

    //Constructor
    public GameBoard(String name) {
        this.name = "Connect Four";
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
