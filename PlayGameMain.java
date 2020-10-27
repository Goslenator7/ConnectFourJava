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
        GameLogic newGame = new GameLogic();
        newGame.startGame();
    }
}
