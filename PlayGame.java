public class PlayGame {
    public static void main(String[] args) {
        GameBoard newGame = new GameBoard("Connect Four");

        newGame.columnDimensions();
        newGame.rowDimensions();
        System.out.println(newGame.getNumOfColumns());
        System.out.println(newGame.getNumOfRows());
    }
}
