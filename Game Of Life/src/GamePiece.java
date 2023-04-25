/*
 * This class defines a Game Piece on a board. A Game Piece is constructed with a value,
 * X position, and y position. A game Piece can also be constructed with just a value ( (0,0) 
 * are x and y coordinates). This class has methods that return the x and y position of 
 * a piece, as well as set the value of a piece
 */
public class GamePiece {
	
	private int value;
	private int xPosition;
	private int yPosition;
	private final int alive = 1;
	private final int dead = 0;
	
	
	
	/*
	 * This method constructs a Game Piece object with 
	 * a value, a x position, a y position
	 * 
	 * Parameters: int v - the value of the piece, int y - y coordinate, int x - x coordinate
	 */

	public GamePiece(int v, int y, int x) {
		this.value = v;
		this.yPosition = y; 
		this.xPosition = x; 
	}
	
	
	
	
	/*
	 * This method constructs a Game Piece object with a value 
	 * at (0,0) as coordinates 
	 * 
	 * Parameters: int v - the value of the piece 
	 */
	
	public GamePiece(int v) {
		this.value = v;
		this.xPosition = 0;
		this.yPosition = 0;
	}
	
	
	
	
	/*
	 * This method constructs a Game Piece that is "alive"
	 * 
	 * Parameters: None
	 */
	
	public GamePiece() {
		this.value = alive;
	}
	
	
	
	
	/*
	 * This method prints out the value of a Game Piece
	 * 
	 * Parameters: None
	 * 
	 * Returns: String a - value of the Game Piece 
	 */
	
	public String toString() {
		String a = "";
		a += this.value;
		return a;
	}
	
	
	
	
	/*
	 * This method returns the value of the Game Piece
	 * 
	 * Parameters: None 
	 * 
	 * Returns: int value - the value of the Game Piece
	 */
	
	public int getPiece() {
		return this.value; 
	}
	
	
	
	
	/*
	 * This method sets of the value of the Game Piece
	 * 
	 * Parameters: int b - new value for the Game Piece
	 * 
	 * Returns: void
	 */
	
	public void setValue(int b) {
		this.value = b; 
	}
	
	
	
	
	/*
	 * This method returns the x coordinate of a Game Piece
	 * 
	 * Parameters: None
	 * 
	 * Returns: int xPosition - x coordinate
	 */
	
	public int getxPosition() {
		return this.xPosition;
	}
	
	
	
	
	/*
	 * This method returns the y coordinate of a Game Piece
	 * 
	 * Parameters: None
	 * 
	 * Returns: int yPosition - y coordinate
	 */
	
	public int getyPosition() {
		return this.yPosition;
	}
	
	
	
	
	/*
	 * This method determines whether the Game Piece is alive
	 * 
	 * Parameters: None 
	 * 
	 * Returns: Boolean (Is the piece alive or not) 
	 */
	
	public boolean isAlive() {
		return getPiece() == alive; 
	}
}
