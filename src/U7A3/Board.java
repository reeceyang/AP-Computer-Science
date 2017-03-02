// Colleague #2
//
// This is the code for the Board class.
// It uses a 2-D array of Pieces.

package U7A3;

import java.awt.Font;

public class Board
{
	private int rows;
	private int cols;
	private Piece[][] board;

	public Board(int r, int c)
	{
		rows = r;
		cols = c;
		board = new Piece[r][c];
	}

	public void drawBoard()
	{
		System.out.println("\n\n\nCurrent Board\n");

		for (int i=0; i<rows; i++)
		{
			for (int j=0; j<cols; j++)
			{
				String theID = board[i][j].getID();
				System.out.print("| " + theID + " ");
			}
			System.out.println("|");
		}
	}

	public void addPiece(Piece x, int r, int c)
	{
		board[r][c] = x;
	}

	public Piece[][] getBoard()
	{
		return board;
	}

	public boolean isOccupied(int r, int c)
	{
		Piece p = board[r][c];
		String q =p.getID();

		if (q.equals(" "))
			return false;

		return true;
	}
}