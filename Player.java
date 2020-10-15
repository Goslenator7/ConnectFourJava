import javax.swing.*;

public class Player {

    private String playerName;
    private char playerColour;

    //Constructor
    public Player() {
        this.getPlayerName();
        this.getPlayerColour();
    }

    // Get the names of player one and player two
    public void playerName() {
        String playerName;

        playerName = JOptionPane.showInputDialog("Enter player name: ");
        setPlayerName(playerName);
    }

    // Ask the player which colour they would like to play as
    // Result will determine the colour of other player, decided during runtime in main
    public void playerColour() {
        String playersColour;

        playersColour = JOptionPane.showInputDialog("Okay, does "+getPlayerName()+" want to be R (red) or Y (yellow?)");

        if (playersColour.equals("red")) {
            setPlayerColour('R');
        }
        else if (playersColour.equals("Red")) {
            setPlayerColour('R');
        }
        else if (playersColour.equals("R")) {
            setPlayerColour('R');
        }
        else {
            setPlayerColour('Y');
        }
    }

    // Ask the user for a column to place their chip in
    public void placeAChip() {
        int columnChoice;

        columnChoice = Integer.parseInt(JOptionPane.showInputDialog("Which column number would you like to place your chip in?"));

        //activate addChipToSpace method in space class accepting integer of column choice?
        //Or select column number equal to input and update that space and the rowSpace as well?
    }

    // Getters and Setters
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public char getPlayerColour() {
        return playerColour;
    }

    public void setPlayerColour(char playerColour) {
        this.playerColour = playerColour;
    }

}
