import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

/*
 * A class that extends the JPanel class, adding the functionality
 * of painting the current generation of a Game of Life.
 */
public class BoardPanel extends JPanel implements MouseListener{
	private GameOfLife game;
	GameOfLifeDisplay disp;
	
	/*
	 * Sets up this initial state of this JPanel given a GameOfLife object and the JFrame
	 * on which it has been placed
	 */
	public BoardPanel(GameOfLife g, GameOfLifeDisplay disp){
		game = g;
		this.disp = disp;
		this.addMouseListener(this);
	}
	
	/**
	 * Paints the current state of the Game of Life board onto
	 * this panel. This method is invoked for you each time you
	 * call repaint() on either this object or on the JFrame upon
	 * which this panel is placed.
	 */
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLACK);
		int width = this.getWidth();
		int height = this.getHeight();
		
		int cellWidth = width / game.numCols();
		int cellHeight = height / game.numRows();
		for(int row = 0; row < game.numRows(); row++) {
			for(int col = 0; col < game.numCols(); col++) {
				if(game.isAlive(row, col)) {
					g2.fillRect(col * cellWidth, row * cellHeight, cellWidth, cellHeight);
				}
				else {
					g2.drawRect(col * cellWidth, row * cellHeight, cellWidth, cellHeight);
				}
			}
		}
	}

	/*
	 * Flips the state of a cell when it is clicked on the game board
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		int width = this.getWidth();
		int height = this.getHeight();
		
		int cellWidth = width / game.numCols();
		int cellHeight = height / game.numRows();
		
		int col = arg0.getX() / cellWidth;
		int row = arg0.getY() / cellHeight;
		
		game.toggleCell(row, col);
		disp.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
}
