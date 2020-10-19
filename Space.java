import java.util.ArrayList;

public class Space {

    private String chipColour; //will be 'R', 'Y' OR 'NA' in colour to signify red, yellow or no chip
    private boolean empty; // will either be true, if chip is already placed there, or false, if no chip there

    // Constructor (Sets to empty by default)
    public Space(boolean empty) {
        setEmpty(empty);
    }

    // Method called when a chip is added, switches space chip status to false (filled)
    public void chipIsAdded() {
        setEmpty(false);
    }

    // Getters and Setters
    public String chipColour() {
        return this.chipColour;
    }

    public void setChip(String chipColour) {
        this.chipColour = chipColour;
    }

    public boolean getEmpty() {
        return this.empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
}
