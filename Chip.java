public class Chip {

    private String chipColour;

    // Constructors
    public Chip() {}
    public Chip(String chipColour) {
        setChipColour(chipColour);
    }

    // Getters and setters
    public String getChipColour() {
        return this.chipColour;
    }

    public void setChipColour(String chipColour) {
        this.chipColour = chipColour;
    }
}
