import javax.swing.*;
import java.text.ParsePosition;
import java.util.ArrayList;

public class GameLogic {

    private String playerOneName;
    private String playerTwoName;
    private String playerOneColour;
    private String playerTwoColour;
    String columnContents;
    private final int NUMOFROWS = 6;
    private final int NUMOFCOLUMNS = 7;
    private int fullColumnCounter = 0;

    GameBoard newGame = new GameBoard(getNUMOFROWS(), getNUMOFCOLUMNS());


    //
    //
    // Game Setup
    //
    //


    // Start the Game
    public void startGame() {
        setNewGame(newGame);
        playerNames();
        playerColours();
        // Start the loop to play the game here
        // 42 possible plays on board, so loop for 44 (extra headroom)
        for (int i = 0; i < 44; i++) {
            playerOneChoice();
            playerTwoChoice();
        }
    }

    // Displays the current layout of the board
    public void displayBoard() {
        for (Row tempRow : newGame.getRows()) {
            System.out.print("");
            //"\t"+tempRow.getRowSpaces().size()
            for (Space tempSpace : tempRow.getRowSpaces()) {
                System.out.print(tempSpace.getChip().getChipColour() + "\t");
            }
            System.out.print("\n");
        }
        System.out.println("\n");
    }

    // Used to clear the board in event of a new game
    public void resetBoard() {

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
            playerOneColour = "R";
            playerTwoColour = "Y";
            playersColours = playerOneName+" is red. "+playerTwoName+" is yellow.";
            JOptionPane.showMessageDialog(null, playersColours, "Your colours", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (playerOneColour.equals("yellow") || playerOneColour.equals("Yellow") || playerOneColour.equals("Y") || playerOneColour.equals("y")) {
            playerOneColour = "Y";
            playerTwoColour = "R";
            playersColours = playerOneName+" is yellow. "+playerTwoName+" is red.";
            JOptionPane.showMessageDialog(null, playersColours, "Your colours", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            colourError = "Sorry, that's not a valid colour. Please try re-entering the colour you want to play as.";
            JOptionPane.showMessageDialog(null, colourError, "Colour Error", JOptionPane.ERROR_MESSAGE);
            playerColours();
        }
    }

    //
    //
    // Get the player's choices for columns
    //
    //

    // Get Player one's choice of column to place chip
    public void playerOneChoice() {

        int playerOneColumnChoice;
        int playerNumber = 1;
        // Get the player's colour and assign to String to pass
        String playerOneColour = getPlayerOneColour();

        // Validate user input as a number and is on the board
        try {
            playerOneColumnChoice = Integer.parseInt(JOptionPane.showInputDialog(playerOneName+", which column number would you like to place your chip in?"));
            checkIfChoiceIsFull(playerOneColumnChoice, playerOneColour, playerNumber);
        }
        catch(Exception e) {
            String errorMessage = "Please enter a valid number input!";
            JOptionPane.showMessageDialog(null, errorMessage, "Input Issue", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Get Player two's choice of column to place chip
    public void playerTwoChoice() {

        int playerTwoColumnChoice;
        int playerNumber = 2;
        String playerTwoColour = getPlayerTwoColour();

        // Validate user input as a number and is on the board
        try {
            playerTwoColumnChoice = Integer.parseInt(JOptionPane.showInputDialog(playerTwoName + ", which column number would you like to place your chip in?"));
            checkIfChoiceIsFull(playerTwoColumnChoice, playerTwoColour, playerNumber);
        }
        catch(Exception e) {
            String errorMessage = "Please enter a valid number input!";
            JOptionPane.showMessageDialog(null, errorMessage, "Input Issue", JOptionPane.ERROR_MESSAGE);
        }
    }

    //
    //
    // Check the player's choice of placement. The following methods check for already placed chips, and horizontal and vertical matches,
    // as well as if there is a draw
    //
    //


    // Get the player's chosen column number, their colour and their number (1 or 2)
    // Check the player's chosen space on the row (their chosen column number) to see if empty or not
    // If it is empty, place a chip of their colour. Otherwise, minus one from the default row to move a row up on the board.
    // Call methods to check for a match in surrounding area
    // Repeat this process until default row is 0 (top of the board is reached)
    // At this point, if space in row 0 is full tell the player that column is full
    // and call the method to pick another column number using their playerNumber
    public void checkIfChoiceIsFull(int thePlayerChoice, String playerColour, int playerNumber) {
        int defaultRow = newGame.getRows().size() - 1;

        if (newGame.getRows().get(defaultRow).getRowSpaces().get(thePlayerChoice - 1).getEmpty() == true) {
            newGame.getRows().get(defaultRow).getRowSpaces().get(thePlayerChoice - 1).addChip(playerColour);
            displayBoard();
            horizontalCheckForMatch(defaultRow, thePlayerChoice, playerColour);
            verticalCheckForMatch(defaultRow, thePlayerChoice, playerColour);
        }
        else {
            while (defaultRow > 0) {
                defaultRow -= 1;
                if (newGame.getRows().get(defaultRow).getRowSpaces().get(thePlayerChoice - 1).getEmpty() == true) {
                    newGame.getRows().get(defaultRow).getRowSpaces().get(thePlayerChoice - 1).addChip(playerColour);
                    displayBoard();
                    horizontalCheckForMatch(defaultRow, thePlayerChoice, playerColour);
                    verticalCheckForMatch(defaultRow, thePlayerChoice, playerColour);
                    break;
                }
                // Triggers when defaultRow 0 (top row) is reached and the column(user's chosen space) is full
                if (defaultRow == 0 && newGame.getRows().get(defaultRow).getRowSpaces().get(thePlayerChoice - 1).getEmpty() == false) {
                    fullColumnCounter += 1;
                    // If fullColumnCounter = 7, all columns are full and the match is a draw so call the gameDraw method
                    if (fullColumnCounter == 7) {
                        gameDraw();
                    }

                    String columnFullMessage = "Sorry, looks like that column is full. Please pick another column! ";
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

    // Check the row that the player just placed on to see if there are 4 of their colours in a row
    public void horizontalCheckForMatch(int theDefaultRow, int thePlayerChoice, String thePlayerColour) {
        String rowContents = "";

        // For every space in the row the player just played in, get the contents
        // add the contents of each space to a string rowContents
        for (Space tempSpace : newGame.getRows().get(theDefaultRow).getRowSpaces()) {
            rowContents = rowContents + tempSpace.whatIsInTheSpace();
        }
        // If there are 4 in a row of either R or Y in rowContents string, then that player wins the game
        if (rowContents.contains("RRRR") || rowContents.contains("YYYY")) {
            JOptionPane.showMessageDialog(null, thePlayerColour+" wins!");

            int choice = JOptionPane.showConfirmDialog(null, "Want to play again?", thePlayerColour+" wins!", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                startGame();
            }
            else {
                JOptionPane.showMessageDialog(null, "Bye bye!", "Thanks for Playing!", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
    }


    // Check the column that the player just played in to see if there are 4 in a row
    public void verticalCheckForMatch(int theDefaultRow, int thePlayerChoice, String thePlayerColour) {
        String spaceContent;

        // Set spaceContent to whatever is in the space ("R" or "Y" or "0")
        // theDefaultRow = defaultRow inherited from checkIfChoiceIsFull method
        for (Row row : newGame.getRows()) {
            // assign the index of the current row in foreach loop to variable rowIndex
            int rowIndex = newGame.getRows().indexOf(row);
            // use rowIndex variable to get the contents of the user's chosen row space on that row
            spaceContent = newGame.getRows().get(rowIndex).getRowSpaces().get(thePlayerChoice - 1).whatIsInTheSpace();
            // Add the row space content to columnContents string
            columnContents += spaceContent;
        }

        // Check the entire columnContents string to see if 4 Rs or Ys appear in a row. If they do, that means the current player wins
        if (columnContents.contains("RRRR") || columnContents.contains("YYYY")) {
            JOptionPane.showMessageDialog(null, thePlayerColour+" wins!");

            int choice = JOptionPane.showConfirmDialog(null, "Want to play again?", thePlayerColour+" wins!", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                startGame();
            }
            else {
                JOptionPane.showMessageDialog(null, "Bye bye!", "Thanks for Playing!", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
    }

    // Will return to finish
    public void diagonalCheckForMatch(int theDefaultRow, int thePlayerChoice, String thePlayerColour) {
        // These variables will represent the point we are at on the board eg. (5(x), 6(y) = 5th space, bottom row
        int x = thePlayerChoice - 1;
        int y = theDefaultRow;


    }


    // Activate if column counter reaches 7 (NUMOFCOLUMNS) to declare draw since no other moves are possible
    // Ask user if they want to play again. if yes, start program again. If no, end the program
    public void gameDraw() {
        String drawMessage = "Looks like there are no more possible moves! It's a draw! \n Want to play again?";
        int choice = JOptionPane.showConfirmDialog(null, drawMessage, "It's a draw!", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            startGame();
        }
        else {
            JOptionPane.showMessageDialog(null, "Bye bye!", "Thanks for playing!", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
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

    public int getFullColumnCounter() {
        return fullColumnCounter;
    }

    public void setFullColumnCounter(int fullColumnCounter) {
        this.fullColumnCounter = fullColumnCounter;
    }

    public GameBoard getNewGame() {
        return newGame;
    }

    public void setNewGame(GameBoard newGame) {
        this.newGame = newGame;
    }

}
