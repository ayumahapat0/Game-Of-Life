/*
 * This class defines the mechanics for the Game Of Life. The Game Of Life is constructed with a board
 * different dimensions, rows by columns or a square board. This class determines
 * whether a cell is alive, the number of neighbors around a cell, the next generations of the cells, 
 * randomizing the board with alive or dead cells, and changing the state of a cell
 */
public class GameOfLife {
	private Board gameBoard;
	private int rows;
	private int cols;
	private int gens;
	private final int alive = 1;
	private final int dead = 0;
	
	
	
	/*
	 * This constructs a game of life object with a board with int row and int col 
	 * 
	 * Parameters: int row and int col  - the dimensions of the board
	 */
	
	public GameOfLife(int row, int col) {
		gameBoard = new Board(row, col);
		this.rows = row;
		this.cols = col; 
	}
	
	
	
	
	/*
	 * This constructs a game of life with a board with a row by row dimension 
	 * 
	 * Parameters: int row - the number of rows 
	 */
	
	public GameOfLife(int row) {
		gameBoard = new Board(row);
	}
	
	
	
	
	/*
	 * This method returns whether the cell is alive or dead at a specific position 
	 * 
	 * Parameters: int row and int col - location of the cell 
	 * 
	 * Returns: boolean (is the piece alive or not) 
	 */
	
	public boolean isAlive(int row, int col) {
		return gameBoard.isOccupied(row, col);
	}
	
	
	
	
	/*
	 * The methods returns the number of rows
	 * 
	 * Parameters: None 
	 *  
	 * Returns: int rows - the number of rows
	 */

	public int numRows() {
		return this.rows;
	}
	
	
	
	
	/*
	 * This method return the number of cols
	 * 
	 * Parameters: None 
	 * 
	 * Returns: int cols - the number of columns
	 */
	
	public int numCols() {
		return this.cols;
	}
	
	
	
	
	/*
	 * This returns the number of generations in total 
	 * 
	 * Parameters: None 
	 * 
	 * Returns: int gen - total number of generations
	 */
	
	public int numGens() {
		return this.gens; 
	}
	
	
	
	
	/*
	 * This methods increases the number of generations
	 * 
	 * Parameters: None 
	 * 
	 * Returns: void
	 */
	
	public void addGeneration() {
		gens++; 
	}
	
	
	
	
	/*
	 * This method "clears" the board
	 * 
	 * Parameters: None
	 * 
	 * Returns: void
	 */
	public void clear() {
		for (int row = 0; row < gameBoard.getRows(); row++) {
			for (int col = 0; col < gameBoard.getCols(); col++){
				gameBoard.getGamePiece(row, col).setValue(dead);
			}
		}
		
		this.gens = 0;
	}
	
	
	
	
	/*
	 * This method receives the location of a cell and 
	 * changes it value (if alive, then dead and vice versa)
	 * 
	 * Parameters: int row, int col - the location of the given cell
	 * 
	 * Returns: void
	 */
	
	public void toggleCell(int row, int col) {
		if (gameBoard.getGamePiece(row, col).isAlive()){
			(gameBoard.getGamePiece(row, col)).setValue(dead);
		}
		else {
			(gameBoard.getGamePiece(row, col)).setValue(alive);
		}
	}
	
	
	
	
	/*
	 * This method randomizes the board with cells
	 * 
	 * Parameters: None 
	 * 
	 * Returns: void
	 */
	
	public void randomize() {
		
		for (int row = 0; row < numRows(); row++) {
			for (int col = 0; col < numCols(); col++) {
				
				double a = Math.random();
				
				if (a >= 0.5) {
					toggleCell(row, col); 
				}
				
			}
		}
		
	}
	
	
	
	
	/*
	 * This method returns the number of alive cells around a given cell
	 * 
	 * Parameters: int row, int col: location of given cell
	 * 
	 * Returns: int neighbors - the number of alive cells around the given cell
	 */
	
	public int neighbor(int row, int col) {
		
		int neighbors = 0;
		
			for (int i = row - 1; i < row + 2; i++) {
				for(int j = col - 1; j < col + 2; j++) {
					if (gameBoard.isinBounds(i, j) && (gameBoard.getGamePiece(i, j)).isAlive() && (i != row || j != col)) {
						neighbors++;
					}
				}
			}
		return neighbors;
	}
	
	
	
	
	/*
	 * This method checks current state of cells and produces the next generation of cells
	 * 
	 * Parameters: None 
	 * 
	 * Returns: void
	 */
	
	public void nextGeneration() {
		
		Board b  = new Board(numRows(), numCols()); 
		
		for (int i = 0; i < gameBoard.getRows(); i++) {
			for (int j = 0; j < gameBoard.getCols(); j++) {
				
				
				int n = neighbor(i,j);
				
				if (gameBoard.getGamePiece(i, j).isAlive() && (n < 2 || n > 3)) {
					b.getGamePiece(i, j).setValue(dead);
				}
				
				if (gameBoard.getGamePiece(i, j).isAlive() && (n == 2 || n == 3)) {
					b.getGamePiece(i, j).setValue(alive);
				}
				
				
				if (!(gameBoard.getGamePiece(i, j)).isAlive() && (n == 3)) {
					b.getGamePiece(i, j).setValue(alive);
				}
			}
		}
		
		gameBoard = b; 
		
		addGeneration(); 
	}
}
