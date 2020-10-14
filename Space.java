import java.util.ArrayList;

public class Space {

    private char chip; //can be set to 'R' or 'Y' to signify red or yellow chip
    private boolean empty; // will either be true, if chip is already placed there, or false, if no chip there


    // Getters and Setters
    public char getChip() {
        return this.chip;
    }

    public void setChip(char chip) {
        this.chip = chip;
    }

    public boolean getEmpty() {
        return this.empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
}
