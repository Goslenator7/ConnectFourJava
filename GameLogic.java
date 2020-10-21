import javax.swing.*;

public class GameLogic {
    private String playerOneName;
    private String playerTwoName;
    private String playerOneColour;
    private String playerTwoColour;
    private final int NUMOFROWS = 6;
    private final int NUMOFCOLUMNS = 7;

    // Start the Game
    public void startGame() {
        GameBoard newGame = new GameBoard(6,7);
        playerNames();
        playerColours();
        playerOneChoice();

        // Test if the rows have been added successfully
        System.out.println(newGame.getRows().size());

        // Test number of spaces in each row
        for (Row tempRow : newGame.getRows()) {
            System.out.print("");
            //"\t"+tempRow.getRowSpaces().size()
            for (Space tempSpace : tempRow.getRowSpaces()) {
                System.out.print(tempSpace.getChip()+"\t");
            }
            System.out.print("\n");
        }
    }

    //
    //
    // Game Setup
    // Get the names of the players and assign them to a colour of disk
    //
    //

    // Get the names of player one and player two
    public void playerNames() {
        playerOneName = JOptionPane.showInputDialog("Enter player one's name: ");
        playerTwoName = JOptionPane.showInputDialog("Enter player Two's name: ");
    }

    // Ask the player which colour they would like to play as
    // Result will determine the colour of player 2
    public void playerColours() {

        String colourError;
        String playersColours;

        playerOneColour = JOptionPane.showInputDialog("Okay, does "+playerOneName+" want to be red or yellow?");

        if (playerOneColour.equals("red") || playerOneColour.equals("Red") || playerOneColour.equals("R") || playerOneColour.equals("r")) {
            playerOneColour = "Red";
            playerTwoColour = "Yellow";
            playersColours = playerOneName+" is red. "+playerTwoName+" is yellow.";
            JOptionPane.showMessageDialog(null, playersColours, "Your colours", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (playerOneColour.equals("yellow") || playerOneColour.equals("Yellow") || playerOneColour.equals("Y") || playerOneColour.equals("y")) {
            playerOneColour = "Yellow";
            playerTwoColour = "Red";
            playersColours = playerOneName+" is yellow. "+playerTwoName+" is red.";
            JOptionPane.showMessageDialog(null, playersColours, "Your colours", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            colourError = "Sorry, that's not a valid colour. Please try re-entering the colour you want to play as.";
            JOptionPane.showMessageDialog(null, colourError, "Colour Error", JOptionPane.ERROR_MESSAGE);
            playerColours();
        }
    }

    // Get Player one's choice of column to place chip
    public int playerOneChoice() {

        int playerOneColumnChoice;

        playerOneColumnChoice = Integer.parseInt(JOptionPane.showInputDialog(playerOneName+", which column number would you like to place your chip in?"));
        return playerOneColumnChoice;
        //activate addChipToSpace method in space class accepting integer of column choice?
    }

    // Get Player one's choice of column to place chip
    public int playerTwoChoice() {

        int playerTwoColumnChoice;

        playerTwoColumnChoice = Integer.parseInt(JOptionPane.showInputDialog(playerTwoName+", which column number would you like to place your chip in?"));
        return playerTwoColumnChoice;
    }

}
