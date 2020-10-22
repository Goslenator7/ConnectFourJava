import javax.swing.*;

public class GameLogic {

    private String playerOneName;
    private String playerTwoName;
    private String playerOneColour;
    private String playerTwoColour;
    private final int NUMOFROWS = 6;
    private final int NUMOFCOLUMNS = 7;
    GameBoard newGame = new GameBoard(6,7);


    //
    //
    // Game Setup
    //
    //


    // Start the Game
    public void startGame() {
        playerNames();
        playerColours();
        // Should start the loop to play the game here!
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
    public void playerOneChoice() {

        int playerOneColumnChoice;
        int playerNumber = 1;
        // Get the player's colour and assign to String to pass
        String playerOneColour = getPlayerOneColour();

        playerOneColumnChoice = Integer.parseInt(JOptionPane.showInputDialog(playerOneName+", which column number would you like to place your chip in?"));

        // Call space check method, passing player's column choice and chip colour
        checkIfChoiceIsFull(playerOneColumnChoice, playerOneColour, playerNumber);
    }

    // Get Player two's choice of column to place chip
    public void playerTwoChoice() {

        int playerTwoColumnChoice;
        int playerNumber = 2;
        String playerTwoColour = getPlayerTwoColour();

        playerTwoColumnChoice = Integer.parseInt(JOptionPane.showInputDialog(playerTwoName+", which column number would you like to place your chip in?"));

        // Call space check method, passing player's column choice and chip colour
        checkIfChoiceIsFull(playerTwoColumnChoice, playerTwoColour, playerNumber);
    }

    // Get the player's chosen column number, their colour and their number (1 or 2)
    // Check the player's chosen space on the row (their chosen column number) to see if empty or not
    // If it is empty, place a chip of their colour. Otherwise, minus one from the default row to move a row up on the board
    // Repeat this process until default row is 0 (top of the board is reached)
    // At this point, tell the player that column is full, and call the method to pick another number using their playerNumber
    public void checkIfChoiceIsFull(int thePlayerChoice, String playerColour, int playerNumber) {
        int defaultRow = 6;

        if (newGame.getRows().get(defaultRow).getRowSpaces().get(thePlayerChoice).getEmpty() == true) {
            newGame.getRows().get(defaultRow).getRowSpaces().get(thePlayerChoice).addChip(playerColour);
        }
        else {
            while (defaultRow > 0) {
                defaultRow -= 1;
                if (newGame.getRows().get(defaultRow).getRowSpaces().get(thePlayerChoice).getEmpty() == true) {
                    newGame.getRows().get(defaultRow).getRowSpaces().get(thePlayerChoice).addChip(playerColour);
                }
                if (defaultRow == 0) {
                    String columnFullMessage = "Sorry, looks like that column is full. Please pick another column";
                    JOptionPane.showMessageDialog(null, columnFullMessage, "Column Full", JOptionPane.ERROR_MESSAGE);
                    if (playerNumber == 1) {
                        playerOneChoice();
                    }
                    else {
                        playerTwoChoice();
                    }
                }
            }
        }
    }

    public GameBoard getNewGame() {
        return newGame;
    }

    //
    //
    // Getters and Setters
    //
    //

    public String getPlayerOneName() {
        return playerOneName;
    }

    public void setPlayerOneName(String playerOneName) {
        this.playerOneName = playerOneName;
    }

    public String getPlayerTwoName() {
        return playerTwoName;
    }

    public void setPlayerTwoName(String playerTwoName) {
        this.playerTwoName = playerTwoName;
    }

    public String getPlayerOneColour() {
        return playerOneColour;
    }

    public void setPlayerOneColour(String playerOneColour) {
        this.playerOneColour = playerOneColour;
    }

    public String getPlayerTwoColour() {
        return playerTwoColour;
    }

    public void setPlayerTwoColour(String playerTwoColour) {
        this.playerTwoColour = playerTwoColour;
    }

    public int getNUMOFROWS() {
        return NUMOFROWS;
    }

    public int getNUMOFCOLUMNS() {
        return NUMOFCOLUMNS;
    }

    public void setNewGame(GameBoard newGame) {
        this.newGame = newGame;
    }

}
