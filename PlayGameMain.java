import javax.swing.*;

public class PlayGameMain {

    public static void welcome() {
        String welcome;

        welcome = "Welcome to Connect 4! Players take turns dropping their chip into a column on the board. \n The first player to line up 4 of their chips in any direction wins the game!";
        JOptionPane.showMessageDialog(null, welcome, "Welcome to Connect Four!", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {

        // Display welcome message
        welcome();

        // Create new game instance
        GameLogic aNewGame = new GameLogic();
        aNewGame.startGame();

        // Method to start the game //main? Done
        // Ask for names of players Done
        // Ask player one which colour of chip they want Done
        // Ask player for column number to place chip Done
        // Update the space of that row/column to have a chip in it (or put it one row up if already full) Done
        // OR tell the player that row is already full and ask for a different column to place Done
        // Check surroundings of that chip to see if there are any matches
        // If 4 matches in a direction are found, display winning message for player
        // If no matches found, proceed to next players turn (Return to Ask player from column number to place chip)

        // update board display after every turn?
    }
}
