/*
 * This class defines a cell as a type of game piece for Game Of Life.
 * A cell can be construct with a value and x and y coordinates, with a value 
 * and default coordinates of (0,0), and with only a value  
 * 
 */
public class Cell extends GamePiece {
	
	private final int alive = 1;
	private final int dead = 0;
	 
	
	
	/*
	 * This constructs a cell that that has an x coordinate 
	 * a y coordinate and a value
	 *  
	 * Parameters: int v - value of Cell, int y - y Position, int x - x Position
	 */
	
	public Cell(int v, int y, int x) {
		super(v, y, x);
	}
	
	
	
	
	/*
	 * This constructs a cell with a value and a default position 
	 * of (0,0) 
	 * 
	 * Parameters: int v - value of Cell
	 */
	
	public Cell(int v) {
		super(v);
	}
	
	
	
	
	/*
	 * Constructs a cell that is alive
	 * 
	 * Parameters: None
	 */
	
	public Cell() {
		super();
	}	
}
