import javax.swing.*;

public class PlayGame {

    public static void welcome() {
        String welcome;

        welcome = "Welcome to Connect 4! Players take turns dropping their chip into a column on the board. \n The first player to line up 4 of their chips in any direction wins the game!";
        JOptionPane.showMessageDialog(null, welcome, "Welcome to Connect Four!", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {

        // Display welcome message
        PlayGame.welcome();

        // Create new game instance
        GameBoard newGame = new GameBoard("Connect Four");


        // Create two new players
        Player player1 = new Player();
        Player player2 = new Player();

        // Ask each player for their name
        player1.playerName();
        player2.playerName();

        // Ask player 1 to select a colour
        player1.playerColour();

        // Set player 2's colour to the option player 1 does not pick
        if (player1.getPlayerColour() == 'R') {
            player2.setPlayerColour('Y');
        }
        else {
            player2.setPlayerColour('R');
        }

        //
        // Test to show assignment of player name and colours. Can be removed for demo
        //
        String message = player1.getPlayerName()+" is "+player1.getPlayerColour()+". "+player2.getPlayerName()+" is "+player2.getPlayerColour()+".";
        JOptionPane.showMessageDialog(null, message);

        // Method to start the game //main? Done
        // Ask for names of players Done
        // Ask player one which colour of chip they want Done
        // Ask player for column number to place chip
        // Update the space of that row/column to have a chip in it (or put it one row up if already full)
        // OR tell the player that row is already full and ask for a different column to place
        // Check surroundings of that chip to see if there are any matches
        // If 4 matches in a direction are found, display winning message for player
        // If no matches found, proceed to next players turn (Return to Ask player from column number to place chip)

        // update board display after every turn?
    }
}
