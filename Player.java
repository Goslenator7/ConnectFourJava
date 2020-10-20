package ConnectFour;
import javax.swing.*;

public class Player {

    private String playerName;
    private String playerColour;

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
            setPlayerColour("R");
        }
        else if (playersColour.equals("Red")) {
            setPlayerColour("R");
        }
        else if (playersColour.equals("R")) {
            setPlayerColour("R");
        }
        else {
            setPlayerColour("Y");
        }
    }

    // Ask the user for a column to place their chip in
    public int playerChoice() {
        int columnChoice;

        columnChoice = Integer.parseInt(JOptionPane.showInputDialog(this.getPlayerName()+", which column number would you like to place your chip in?"));
        return columnChoice;
        //activate addChipToSpace method in space class accepting integer of column choice?
    }

    // Getters and Setters
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerColour() {
        return playerColour;
    }

    public void setPlayerColour(String playerColour) {
        this.playerColour = playerColour;
    }

}
