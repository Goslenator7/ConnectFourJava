import javax.swing.*;

public class GameLogic {

    private String playerOneName;
    private String playerTwoName;
    private String playerOneColour;
    private String playerTwoColour;
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
        // Should start the loop to play the game here!
        for (int i = 0; i < 7; i++) {
            playerOneChoice();
            playerTwoChoice();
        }


        /*// Test if the rows have been added successfully
        System.out.println(newGame.getRows().size());

        // Test number of spaces in each row

        for (Row tempRow : newGame.getRows()) {
            System.out.print("");
            //"\t"+tempRow.getRowSpaces().size()
            for (Space tempSpace : tempRow.getRowSpaces()) {
                System.out.print(tempSpace.getChip()+"\t");
            }
            System.out.print("\n");
        }*/
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
    // At this point, if space in row 0 is full tell the player that column is full
    // and call the method to pick another column number using their playerNumber
    public void checkIfChoiceIsFull(int thePlayerChoice, String playerColour, int playerNumber) {
        int defaultRow = newGame.getRows().size() - 1;

        if (newGame.getRows().get(defaultRow).getRowSpaces().get(thePlayerChoice - 1).getEmpty() == true) {
            newGame.getRows().get(defaultRow).getRowSpaces().get(thePlayerChoice - 1).addChip(playerColour);
            displayBoard();
            horizontalCheckForMatch(defaultRow, thePlayerChoice, playerColour);
        }
        else {
            while (defaultRow > 0) {
                defaultRow -= 1;
                if (newGame.getRows().get(defaultRow).getRowSpaces().get(thePlayerChoice - 1).getEmpty() == true) {
                    newGame.getRows().get(defaultRow).getRowSpaces().get(thePlayerChoice - 1).addChip(playerColour);
                    displayBoard();
                    horizontalCheckForMatch(defaultRow, thePlayerChoice, playerColour);
                    break;

                }
                // Triggers when defaultRow 0 is reached and the column(user's chosen space) is full
                if (defaultRow == 0 && newGame.getRows().get(defaultRow).getRowSpaces().get(thePlayerChoice - 1).getEmpty() == false) {
                    fullColumnCounter += 1;
                    // If fullColumnCounter = 7, call the gameDraw method? (to be added)
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
        int rowSpace = 0;

        for (Space tempSpace : newGame.getRows().get(theDefaultRow).getRowSpaces()) {
            rowContents = rowContents + tempSpace.whatIsInTheSpace();
        }

        System.out.println(rowContents);

        //rowContents = rowContents + newGame.getRows().get(theDefaultRow).getRowSpaces().get(rowSpace).whatIsInTheSpace();

        // Loop until we reach the end of the row
        /*while (rowSpace < newGame.getRows().get(theDefaultRow).getRowSpaces().size() - 1) {
            rowContents = rowContents + newGame.getRows().get(theDefaultRow).getRowSpaces().get(rowSpace).whatIsInTheSpace();
            rowSpace++;
        }
        System.out.println(rowContents);
        if (rowContents.contains("RRRR") || rowContents.contains("YYYY")) {
            // Run playerWins(playerColour)
            JOptionPane.showMessageDialog(null, thePlayerColour+" wins!");
        }*/
    }

    // Activate if column counter reaches 7 (NUMOFCOLUMNS) to declare draw since no other moves are possible
    public void gameDraw() {
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
