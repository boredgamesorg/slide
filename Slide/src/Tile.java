
public class Tile {
	
	private int tileID;
	private String tileImg;
	private int tileX;
	private int tileY;
	private boolean isEmpty = false;
	
	
	//getters
	public int getID() {
		return tileID;
	}
	
	public String getImg() {
		return tileImg;
	}
	
	public int getX() {
		return tileX;
	}
	
	public int getY() {
		return tileY;
	}
	
	public boolean checkEmpty() {
		return isEmpty;
	}
	
	//setters
	public void setID(int ID) {
		tileID = ID;
	}
	
	public void setImg(String Img) {
		tileImg = Img;
	}
	
	public void setX(int x) {
		tileX = x;
	}
	
	public void setY(int y) {
		tileY = y;
	}
	
	public void setEmpty(boolean a) {
		isEmpty = a;
	}
	
	public static void main(String[] args) {

	}

}
