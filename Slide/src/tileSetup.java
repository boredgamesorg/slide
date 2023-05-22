import javax.swing.JButton;

public class tileSetup {
	static int dimension = 3;
	static int emptyTileIndex = 8;
	
	public static void changeDimension(int newDimension) {
		changeDimension(newDimension, true);
	}
	
	public static void changeDimension(int newDimension, boolean changeEmptyTileIndex) {
		dimension = newDimension;
		if (changeEmptyTileIndex == true) {
			emptyTileIndex = newDimension * newDimension - 1;
		}
	}
	
	public static void changeEmptyTile(int newIndex) {
		emptyTileIndex = newIndex;
	}
	
	public static Tile[] setup(JButton[] buttons) {
		int len = dimension * dimension;
		Tile board[] = new Tile[len];
		
		if (buttons.length != len) {
			throw new IllegalArgumentException("The number of buttons is not correct for dimension provided! (" +
		buttons.length + " provided " + len + " needed)");
		}
		
		for (int i = 0; i < len; i++) {
			board[i] = new Tile(i, buttons[i]);
		}
		
		board[emptyTileIndex].setEmpty(true);
		return board;
	}
	
	public static boolean completed(Tile[] tileArr) {		
		for (int i = 0; i < tileArr.length; i++) {
			if (tileArr[i].id() != i) {
				return false;
			}
		}
		return true;
	}
	
}
