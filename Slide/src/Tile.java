import javax.swing.JButton;

public class Tile {
	
	private int id;
	private JButton btn;
	private boolean empty = false;
	
	// Constructors
	public Tile(int id, JButton btn) {
		this.id = id;
		this.btn = btn;
	}
	
	public Tile(int id) {
		this.id = id;
	}
	
	public Tile(Tile t) {
		this.id = t.id;
		this.btn = t.btn;
		this.empty = t.empty;
	}
	
	public Tile() {}
	
	//getters
	public int id() {
		return id;
	}
	
	public JButton btn() {
		return btn;
	}
	
	public boolean empty() {
		return empty;
	}
	
	
	//setters
	public void setId(int id) {
		this.id = id;
	}
	
	public void setbtn(JButton btn) {
		this.btn = btn;
	}
	
	public void setEmpty(boolean empty) {
		this.empty = empty;
	}
};