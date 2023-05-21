import javax.swing.JButton;

public class testingCode {
	
	// Run to check if back end works, without even initializing front end tasks
	public static void main(String[] args) {
		JButton arr[] = {new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton()};
		Tile tiles[] = tileSetup.setup(arr);
				
		showPositions(tiles);
		
		tiles = tileMovement.move(tiles,7);
		showPositions(tiles);
		
		tiles = tileMovement.move(tiles, 1);
		showPositions(tiles);
		
		tiles = tileMovement.move(tiles, 2);
		showPositions(tiles);
		
		tiles = tileMovement.move(tiles, 0);
		showPositions(tiles);
	}
	
	public static void showPositions(Tile[] tiles) {
		for (int i = 0; i < tiles.length; i++) {
			if (i % tileSetup.dimension == 0) {
				System.out.println("\n");
			}
			System.out.print(tiles[i].id() + " ");
		}
		System.out.println("\n\n\n");
		
	}
}
