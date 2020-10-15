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

        // For some reason, it would not accept these as chained || statements, so had to do them this way
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
        // Can set the next player to a different colour once player objects have been created in main?
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
