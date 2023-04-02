import java.util.*;
import java.util.stream.*;

public class Slide {

	public static void main(String[] args) {
		//Setting up a demo array of images, will get dynamic image source array from Azaken's code once we add that
		String arr[] = new String[] {"Demo tiles/tile0_0.png", "Demo tiles/tile0_1.png", "Demo tiles/tile0_2.png", "Demo tiles/tile1_0.png", "Demo tiles/tile1_1.png", "Demo tiles/tile1_2.png", "Demo tiles/tile2_0.png", "Demo tiles/tile2_1.png", "Demo tiles/tile2_2.png"};
		int n = 3;
		Tile tiles[] = setup(arr, n);
		
		tiles[8].setEmpty(true);
		
		// Placeholder code to test if everything is working as it is supposed to
		showpositions(tiles);
		
		tiles = move(tiles,tiles[7]);
		showpositions(tiles);
	}
	
	public static int showpositions(Tile[] tiles) {
		for (Tile tile : tiles) {
			System.out.println(String.format("Tile at position (%d, %d) with image %s and having ID %d. Empty attribute is %b", tile.getX(), tile.getY(), tile.getImg(), tile.getID(), tile.checkEmpty()));
		}
		return 0;
	}
	public static Tile[] setup(String[] links, int n) {
		Tile tiles[] = new Tile[links.length];
 		for (int i = 0; i < links.length; i++) {
	 			Tile temp = new Tile(i, links[i], i % n, i / n);
				tiles[i] = temp;
 			}
		return tiles;
	}
	
	public static Tile[] move(Tile[] positions, Tile clicked) {
		int clickX = clicked.getX();
		int clickY = clicked.getY();
		var empty = Arrays.asList(positions).stream().filter(obj -> obj.checkEmpty()).findFirst().orElse(null);
		
		if (empty == null) {
			throw new NullPointerException("Couldn't find empty tile!");
		}
		
		int ex = empty.getX();
		int ey = empty.getY();
		if (clickX == ex + 1 || clickX == ex - 1 || clickY == ey + 1 || clickY == ey - 1) {
			clicked.setX(ex);
			clicked.setY(ey);
			empty.setX(clickX);
			empty.setY(clickY);
		}
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
