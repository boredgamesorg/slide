
public class Slide {

	public static void main(String[] args) {
		
		Tile tile1 = new Tile();
		tile1.setID(0);
		tile1.setX(0);
		tile1.setY(1);
		
		Tile tile2 = new Tile();
		tile2.setID(1);
		tile2.setX(0);
		tile2.setY(0);
		
		System.out.println("Tile 1 has ID: " + tile1.getID() + " and is at position (" + tile1.getX() + ", " + tile1.getY() + ")");
		System.out.println(String.format("Tile 2 has ID: %d and is at position (%d, %d)", tile2.getID(), tile2.getX(), tile2.getY()));
	}

}
