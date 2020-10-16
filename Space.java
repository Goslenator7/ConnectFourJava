import java.util.ArrayList;

public class Space {

    private Chip chip; //will be 'R' or 'Y' in colour to signify red or yellow chip
    private boolean empty; // will either be true, if chip is already placed there, or false, if no chip there

    // Constructor
    public Space(boolean empty) {
        setEmpty(empty);
    }

    // Getters and Setters
    public Chip getChip() {
        return this.chip;
    }

    public void setChip(Chip chip) {
        this.chip = chip;
    }

    public boolean getEmpty() {
        return this.empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
}
