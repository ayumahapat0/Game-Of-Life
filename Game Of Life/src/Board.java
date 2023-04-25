/*
 * This class defines a board made of Game Pieces for a game with dimensions of rows and columns. 
 * The board can also be constructed with a square dimension or with a given board. The different
 * methods are placing, removing, or getting a game piece,
 * clearing the board, and checking if certain coordinates are in bounds  
 */
public class Board {
    
	private GamePiece[][] Board;
	private int rows;
	private int cols;
	private final int alive = 1;
	private final int dead = 0;
	
	
	
	/*
	 * This method constructs a Board object with a dimension of rows by columns
	 * 
	 * Parameters: int row and int col - dimensions of the board
	 */
	
	public Board(int row, int col) {
		Board = new GamePiece[row][col];
		this.rows = row;
		this.cols = col;
		
		
		for (int r = 0; r < Board.length; r++) {
			for (int c = 0; c < Board[r].length; c++) {
				Board[r][c] = new GamePiece(dead, r, c);
			}
		}
	}
	
	
	
	
	/*
	 * This method constructs a Board object with a dimension of row by row
	 * 
	 * Parameters: int row - the number of rows
	 */
	
	public Board(int row) {
		Board = new GamePiece[row][row];
		
		for (int r = 0; r < Board.length; r++) {
			for (int r2 = 0; r < Board[r].length; r2++) {
				Board[r][r2] = new GamePiece(dead, r, r2);
			}
		}
	}
	
	
	
	
	/*
	 * This method constructs a Board object given a 2D array of Game Pieces
	 * 
	 * Parameters: GamePiece[row][col] - initial set up
	 */
	
	public Board(GamePiece[][] a){
		int row = this.rows;
		int col = this.cols;
		Board = a;
		
		for (int r = 0; row < Board.length; row++) {
			for (int c = 0; col < Board[row].length; col++) {
				Board[r][c] = new GamePiece(dead, row, col);
			}
		}
	}
	
	
	
	
	/*
	 * This method prints out the value of each piece in 
	 * on the board
	 * 
	 * Parameters: None 
	 * 
	 * Returns: String value - the value of a piece on the Board
	 */
	
	public String toString() {
		
		String value = "";
		
		for (int row = 0; row < Board.length; row++) {
			for (int col = 0; col < Board[row].length; col++) {
				value = Board[row][col].toString();
			}
		}
		return value;	
	}
	
	
	
	
	/*
	 * This method returns the number of rows
	 * 
	 * Parameters: None 
	 * 
	 * Returns: int rows - the number of rows 
	 */
	
	public int getRows() {
		return this.rows; 
	}
	
	
	
	
	/*
	 * This method returns the number of cols
	 *  
	 * Parameters: None 
	 * 
	 * Returns: int cols - the number of columns 
	 */
	
	public int getCols() {
		return this.cols; 
	}
	
	
	
	
	/*
	 * This method clears the board by setting each Game Piece to dead
	 * 
	 * Parameters: None 
	 * 
	 * Returns: void
	 */
	
	public void clear() {
		for(int r = 0; r < Board.length; r++) {
			for (int c = 0; c < Board[r].length; c++) {
				Board[r][c] = new GamePiece(dead, r, c); 
			}
		}
	}
	
	
	
	
	/*
	 * This method "places" a GamePiece at a specific location 
	 * and returns the Game Piece itself 
	 * 
	 *Parameters: int row, int col, - Position of the Game Piece, GamePiece P 
	 *
	 *Returns: GamePiece P 
	 */
	
	public GamePiece placePiece(int row, int col, GamePiece P) {
		Board[row][col] = P;
		return P;
	}
	
	
	
	
	/*
	 * This method "removes" a GamePiece at a specific location 
	 * and returns that piece itself 
	 * 
	 *Parameters: int col, int col, - Position of the Game Piece GamePiece P 
	 *
	 *Returns: the game piece at that location 
	 */
	
	public GamePiece removePiece(int row, int col) {
		if(Board[row][col].getPiece() == alive) {
			Board[row][col] = new GamePiece(dead);
		}
		return Board[row][col];
	}
	
	
	
	
	/*
	 * This method return a Game Piece at a specific location 
	 * 
	 * Parameters: int row, int col - location of the Game Piece
	 * 
	 * 
	 * returns: a Game Piece at that location
	 */
	
	public GamePiece getGamePiece(int row, int col) {
		return Board[row][col];
	}
	
	
	
	
	/*
	 * This method checks whether there is a Game Piece at this spot 
	 * 
	 * 
	 * Parameters: int row, int col - the coordinates
	 * 
	 * Returns: boolean (whether there is a place at that location)
	 */
	
	public boolean isOccupied(int row, int col) {
		if (Board[row][col].getPiece() == alive) {
			return true;
		}
		else{
			return false;
		}
	}
	
	
	
	
	/*
	 * This method checks whether a given location is on the board or not 
	 * 
	 * Parameters: int row, int col - the coordinates 
	 * 
	 * Returns: boolean (whether the coordinates are valid) 
	 */
	
	public boolean isinBounds(int row, int col) {
		if (row > this.getRows() - 1 || col > this.getCols() - 1) {
			return false;
		}
		
		else if (row < 0 || col < 0) {
			return false;
		}
		else {
			return true;
		}
	}	
}
