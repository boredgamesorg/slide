public class Slide {

	public static void main(String[] args) {
		// Setting up a demo array of images, will get dynamic image source array from Azaken's code once we add that
		String arr[][] = new String[][] {{"Demo tiles/tile0_0.png", "Demo tiles/taile0_1.png", "Demo tiles/tile0_2.png"}, {"Demo tiles/tile1_0.png", "Demo tiles/tile1_1.png", "Demo tiles/tile1_2.png"}, {"Demo tiles/tile2_0.png", "Demo tiles/tile2_1.png", "Demo tiles/tile2_2.png"}};
		
		Tile tiles[][] = setup(arr);
		
		
		
		
		// Placeholder code to test if everything is working as it is supposed to
		for (Tile[] row : tiles) {
			for (Tile tile: row) {
			System.out.println(String.format("Tile at position (%d, %d) with image %s and having ID %d", tile.getX(), tile.getY(), tile.getImg(), tile.getID()));
			}
		}
	}
	
	
	public static Tile[][] setup(String[][] links) {
		Tile tiles[][] = new Tile[links.length][links[0].length];
 		for (int i = 0; i < links.length; i++) {
 			for (int j = 0; j < links[i].length; j++) {
	 			Tile temp = new Tile();
	 			
	 			int id = i * links[i].length + j;
				temp.setID(id);
				
				temp.setImg(links[i][j]);
				temp.setY(i);
				temp.setX(j);
				tiles[i][j] = temp;
 			}
		}
		return tiles;
	}


}
