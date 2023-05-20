import java.util.*;
import java.lang.Math;
import java.util.stream.*;

import javax.swing.JButton;

public class Slide {

	public static void main(String[] args) {
		//Setting up a demo array of images, will get dynamic image source array from Azaken's code once we add that
		JButton arr[] = {};
		int n = 3;
		Tile tiles[] = setup(arr, n);
		
		tiles[8].setEmpty(true);
		
		// Placeholder code to test if everything is working as it is supposed to
		showpositions(tiles);
		
		tiles = move(tiles,tiles[7]);
		showpositions(tiles);
		
		tiles = move(tiles, tiles[1]);
		showpositions(tiles);
		
		tiles = move(tiles, tiles[2]);
		showpositions(tiles);
		
		tiles = move(tiles, tiles[0]);
		showpositions(tiles);
	}
	
	public static int showpositions(Tile[] tiles) {
		int x = (int) Arrays.asList(tiles).stream().filter(obj -> {return obj.getX() == 0;}).count();
		int y = (int) Arrays.asList(tiles).stream().filter(obj -> {return obj.getY() == 0;}).count();
		Tile other = new Tile(-1, new JButton(), -1, -1);
		
		for (int i = 0; i < y; i++) {
			// System.out.println(String.format("Tile at position (%d, %d) with image %s and having ID %d. Empty attribute is %b", tile.getX(), tile.getY(), tile.getImg(), tile.getID(), tile.checkEmpty()));
			for (int j = 0; j < x; j++) {
				int thing = j;
				int other_thing = i;
				Tile a = (Tile) Arrays.asList(tiles).stream().filter(obj -> {return obj.getX() == thing && obj.getY() == other_thing;}).findFirst().orElse(other);
				System.out.print(a.getID() + " ");
			}
			System.out.println("\n");
		}
		System.out.println("\n");
		System.out.println("\n");
		return 0;
	}
	public static Tile[] setup(JButton[] links, int n) {
		Tile tiles[] = new Tile[links.length];
		n = (int)Math.sqrt(n);
 		for (int i = 0; i < links.length; i++) {
	 			Tile temp = new Tile(i, links[i], i % n, i / n);
				tiles[i] = temp;
 			}
 		tiles[8].setEmpty(true);
 		
		return tiles;
	}
	
	public static double distance(Tile x, Tile y) {
		double dist;
		int xx = x.getX();
		int yx = y.getX();
		int xy = x.getY();
		int yy = y.getY();
		dist = (int) Math.sqrt(xx * xx + yy * yy);
		return dist;
	}
	
	public static Tile[] move(Tile[] positions, Tile clicked) {
		int clickX = clicked.getX();
		int clickY = clicked.getY();
		var empty = Arrays.asList(positions).stream().filter(obj -> obj.checkEmpty()).findFirst().orElse(null);
		
		if (empty == null) {
			throw new NullPointerException("Couldn't find empty tile!");
		}
		
		if (clicked.checkEmpty() == true) {
			return positions;
		}
		int ex = empty.getX();
		int ey = empty.getY();
		if (distance(clicked, empty) == 1) {
			clicked.setX(ex);
			clicked.setY(ey);
			empty.setX(clickX);
			empty.setY(clickY);
		} else if (clickX == ex) {
			if (clickY > ey) {
				var row = Arrays.asList(positions).stream().filter(obj -> {return obj.getX() == ex && obj.getY() > ey && obj.getY() <= clickY;}).toArray();
				for (Object i: row) {
					Tile j = (Tile) i;
					j.setY(j.getY() - 1);
				}
				empty.setY(clickY);
			} else if (clickY < ey) {
				var row = Arrays.asList(positions).stream().filter(obj -> {return obj.getX() == ex && obj.getY() < ey && obj.getY() >= clickY;}).toArray();
				for (Object i: row) {
					Tile j = (Tile) i;
					j.setY(j.getY() + 1);
				}
				empty.setY(clickY);
			}
		} else if (clickY == ey) {
			if (clickX > ex) {
				var row = Arrays.asList(positions).stream().filter(obj -> {return obj.getY() == ey && obj.getX() > ex && obj.getX() <= clickX;}).toArray();
				for (Object i: row) {
					Tile j = (Tile) i;
					j.setX(j.getX() - 1);
				}
				empty.setX(clickX);
			} else if (clickX < ex) {
				var row = Arrays.asList(positions).stream().filter(obj -> {return obj.getY() == ey && obj.getX() < ex && obj.getX() >= clickX;}).toArray();
				for (Object i: row) {
					Tile j = (Tile) i;
					j.setX(j.getX() + 1);
				}
				empty.setX(clickX);
			}
		}
		return positions;
	}

}
