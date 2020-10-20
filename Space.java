import javax.swing.*;
import java.util.ArrayList;

public class Space {

    private String chipColour; //will be 'R', 'Y' OR 'NA' in colour to signify red, yellow or no chip
    private boolean empty; // will either be true, if chip is already placed there, or false, if no chip there

    // Constructor (Sets to empty by default)
    public Space(String chipColour, boolean empty) {
        setEmpty(empty);
        // Default
        setChipColour("NA");
    }

    // Once a chip is added, set the space empty to false and chipColour to player's colour
    public void addChip(int columnChoice) {
        if (this.getEmpty() == true) {
            this.setChipColour(new Player().getPlayerColour());
        }
    }

    // Getters and Setters
    public String getChipColour() {
        return this.chipColour;
    }

    public void setChipColour(String chipColour) {
        this.chipColour = chipColour;
    }

    public boolean getEmpty() {
        return this.empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
}
