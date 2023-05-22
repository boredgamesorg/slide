public class tileMovement {
	public static Tile[] move(Tile[] positions, int clicked) {
		int empty = tileSetup.emptyTileIndex;
		// System.out.println("Moving index " + clicked + " while empty index is " + empty);
		
		if (clicked == empty) {
			return positions;
		}
		
		int dimension = tileSetup.dimension;
		int cx = clicked % dimension;
		int cy = clicked / dimension;
		int ex = empty % dimension;
		int ey = empty / dimension;
		
		if (cx != ex && cy != ey) {
			return positions;
		}
		
		// System.out.println("Positions are: (" + cx + ", " + cy + ") and (" + ex + ", " + ey + ")");
		
		if (cy == ey) {
			if (cx > ex) {
				Tile emptyTile = new Tile(positions[empty]);
				for (int i = empty; i < clicked; i++) {
					positions[i] = positions[i + 1];
				}
				positions[clicked] = emptyTile;
			}
			
			if (cx < ex) {
				Tile emptyTile = new Tile(positions[empty]);
				for (int i = empty; i > clicked; i--) {
					positions[i] = positions[i - 1];
				}
				positions[clicked] = emptyTile;
			}
		}
		
		if (cx == ex) {
			if (cy > ey) {
				Tile emptyTile = new Tile(positions[empty]);
				for (int i = empty; i < clicked; i += dimension) {
					positions[i] = positions[i + dimension];
				}
				positions[clicked] = emptyTile;
			}
			
			if (cy < ey) {
				Tile emptyTile = new Tile(positions[empty]);
				for (int i = empty; i > clicked; i -= dimension) {
					positions[i] = positions[i - dimension];
				}
				positions[clicked] = emptyTile;
			}
		}

		tileSetup.emptyTileIndex = clicked;
		
		return positions;
	}
}
