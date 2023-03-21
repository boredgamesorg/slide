public class Slide {

	public static void main(String[] args) {
		// Setting up a demo array of images, will get dynamic image source array from Azaken's code once we add that
		String arr[][] = new String[][] {{"Demo tiles/tile0_0.png", "Demo tiles/tile0_1.png", "Demo tiles/tile0_2.png"}, {"Demo tiles/tile1_0.png", "Demo tiles/tile1_1.png", "Demo tiles/tile1_2.png"}, {"Demo tiles/tile2_0.png", "Demo tiles/tile2_1.png", "Demo tiles/tile2_2.png"}};
		
		
		Tile tiles[][] = setup(arr);
		tiles[2][2].setEmpty(true);
		
		
		
		
		// Placeholder code to test if everything is working as it is supposed to
		for (Tile[] row : tiles) {
			for (Tile tile: row) {
			System.out.println(String.format("Tile at position (%d, %d) with image %s and having ID %d. Empty attribute is %b", tile.getX(), tile.getY(), tile.getImg(), tile.getID(), tile.checkEmpty()));
			}
		}
	}
	
	
	public static Tile[][] setup(String[][] links) {
		Tile tiles[][] = new Tile[links.length][links[0].length];
 		for (int i = 0; i < links.length; i++) {
 			for (int j = 0; j < links[i].length; j++) {
 				int id = i * links[i].length + j;
	 			Tile temp = new Tile(id, links[i][j], j, i);
				tiles[i][j] = temp;
 			}
		}
		return tiles;
	}
	
	public static Tile[][] move(Tile[][] positions, Tile clicked) {
		int clickX = clicked.getX();
		int clickY = clicked.getY();
		
				
		return positions;
	}
	
//	public static List<Tile> nearby(Tile[][] positions, Tile required) {
//		List<Tile> adjacentTiles = new ArrayList<Tile>();
//		int x = required.getX();
//		int y = required.getY();
//		
//		// Above
//		if (y != 0) {
//			adjacentTiles.add(positions[x][y-1]);
//		}
//		
//		// Below
//		if (y != positions.length) {
//			adjacentTiles.add(positions[x][y+1]);
//		}
//		
//		// Left
//		if (x != 0) {
//			adjacentTiles.add(positions[x-1][y]);
//		}
//		
//		// Right
//		if (x != positions[0].length) {
//			adjacentTiles.add(positions[x+1][y]);
//		}
//		
//		return adjacentTiles;
//	}
 
}
