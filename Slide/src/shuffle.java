import java.util.Random;

public class shuffle {
	private static int SIZE = tileSetup.dimension;
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right

    public static Tile[] generateShuffledButtons(Tile[] buttons) {
        Random random = new Random();

        // Shuffle the puzzle using Fisher-Yates algorithm
        int emptyRow = SIZE - 1;
        int emptyCol = SIZE - 1;
        int numSwaps = 100; // Number of random swaps to perform
        
        while (numSwaps > 0) {
            int randomDirection = random.nextInt(4); // Randomly select a direction (0: Up, 1: Down, 2: Left, 3: Right)
            int newRow = emptyRow + DIRECTIONS[randomDirection][0];
            int newCol = emptyCol + DIRECTIONS[randomDirection][1];

            if (isValidPosition(newRow, newCol)) {
                // Swap the empty cell with the neighbor
                Tile temp = buttons[emptyRow * SIZE + emptyCol];
                buttons[emptyRow * SIZE + emptyCol] = buttons[newRow * SIZE + newCol];
                buttons[newRow * SIZE + newCol] = temp;

                emptyRow = newRow;
                emptyCol = newCol;
                numSwaps--;
            }
        }
        tileSetup.emptyTileIndex = emptyRow + emptyCol * 3;
        return buttons;
    }

    private static boolean isValidPosition(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }

}
