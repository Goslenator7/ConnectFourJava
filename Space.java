import javax.swing.*;
import java.util.ArrayList;

public class Space {

    private boolean empty; // will either be true, if chip is already placed there, or false, if no chip there
    private Chip aChip = new Chip();

    // Constructor (Sets to empty by default)
    public Space(boolean empty) {
        // Default
        setEmpty(empty);
    }

    // Getters and Setters
    public boolean getEmpty() {
        return this.empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public Chip getChip() {
        return this.aChip;
    }

    // Once a chip is added, set the space empty to false and chipColour to player's colour
    public void addChip(String chipColour) {
        this.empty = false;
        this.aChip.setChipColour(chipColour);
    }

    // Find out what's in the space

    public String whatIsInTheSpace() {
        String inTheSpace = "";
        if (getEmpty()) {
            inTheSpace = "O";
        }
        else if (getChip().getChipColour() == "Red") {
            inTheSpace = "R";
        }
        else if (getChip().getChipColour() == "Yellow") {
            inTheSpace = "Y";
        }
        return inTheSpace;
    }
}
