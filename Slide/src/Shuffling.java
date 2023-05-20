import java.util.Arrays;
import java.util.Random;
import javax.swing.JButton;

public class Shuffling {

    private static final int SIZE = 3;
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right

    public static Tile[] generateShuffledButtons(Tile[] buttons) {
        int[][] puzzle = createSolvedPuzzle();
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
        
        for(int i = 0; i < buttons.length; i++ ){
        	
        	buttons[i].setX(i%3);
        	buttons[i].setY(i/3);
        }

        return buttons;
    }

    private static boolean isValidPosition(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }

    private static int[][] createSolvedPuzzle() {
        int[][] puzzle = new int[SIZE][SIZE];
        int value = 1;

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                puzzle[row][col] = value;
                value++;
            }
        }

        puzzle[SIZE - 1][SIZE - 1] = 0; // Empty cell

        return puzzle;
    }
}
