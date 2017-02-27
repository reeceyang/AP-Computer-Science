//Dhruv Khanna
//
/* This is the Board class that will create a new Board,
*/
/*
public class Board
{
	private String Gametype;
	private int [][]peices = new int [6][6];
	private int winlength = 4;

	public static void main(String [] args)
	{
		Board o = new Board("c4");
	}

	public Board(String gt)
	{
		int row = 0;
		int col = 0;
		Gametype = gt;
		if(Gametype == "ttt")
		{
			tictactoeconstruct();
			int ticlist[] = new int [3];
			place(row, col);
			winlength = 3;
			boolean che = checktic(row, col);
		}
		else if(Gametype == "c4")
		{
			connectfourconstruct();
			int arraylist[] = new int[7];
			winlength = 4;
			place(col);

		}
	}

	private void tictactoeconstruct()
	{
		String tic[][] = new String [6][6];
		for(int a=0; a<=2; a++)
		{
			for(int b=0; b<=2; b++)
			{
				tic[a][b] ="| ";
				System.out.print(tic[a][b]);
			}
			System.out.println();
		}
	}

	private void connectfourconstruct()
	{
		String connect[][] = new String [7][7];
		for(int a=0; a<=6; a++)
		{
			for(int b=0; b<=6; b++)
			{
				connect[a][b] = "| ";
				System.out.print(connect[a][b]);
			}
			System.out.println();
		}
	}

	public void place(int row, int col)
	{
		String a[][] = new String [9][9];
		if(a[row][col] == " ")
			a[row][col] = "*";

	}

	public void place(int col)
	{
		String b[] = new String [16];
		for(int a = col; a>=0; a--)
		{
			if(b[a] == " ")
				b[a] = "*";
		}
	}

	public boolean check()
	{
		int row = 0;
		int col = 0;
		String a[] = new String [5][5];
		if((a[row][col] == a[row+1][col+1]) && (a[row][col] == a[row-1][col-1]))
		try
		{
			a[row+1][col+1];
			a[row-1][col-1];
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			break;
		}
		if((a[row][col] == a[row+1][col]) && (a[row][col] == a[row-1][col]))
		{
				try
				{
					a[row+1][col+1];
					a[row-1][col-1];
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					break;
		}
		if((a[row][col] == a[row][col+1]) && (a[row][col] == a[row][col-1]))
		try
		{

	}

}
*/
package U7A3;

public class Board
{
    private Piece[][] pieces;
    private int boardLength;
    public Board(int boardLength)
    {
        this.boardLength = boardLength;
        pieces = new Piece[boardLength][boardLength];
        clear();
    }
    public void place(int row, int col, Piece piece)
    {
        pieces[row][col] = piece;
    }
    public void clear()
    {
        for (int i = 0; i < boardLength; i++)
        {
            for (int j = 0; j < boardLength; j++)
            {
                pieces[i][j] = Piece.EMPTY;
            }
        }
    }
    public Piece getPiece(int row, int col)
    {
        return pieces[row][col];
    }
    public Piece[][] getPieces()
    {
        return pieces;
    }
    public Piece checkForWin()
    {
        int winner = 0;
        // Horizontal
        for (int i = 0; i < boardLength; i++) {
            for (int j = 0; j < boardLength - 1; j++) {
                if (!pieces[i][j].equals(pieces[i][j + 1])) {
                    break;
                }
                if (j + 1 == boardLength - 1) {
                    winner += pieces[i][0].getType();
                }
            }
        }
        // Vertical
        for (int i = 0; i < boardLength; i++) {
            for (int j = 0; j < boardLength - 1; j++) {
                if (!pieces[j][i].equals(pieces[j + 1][i])) {
                    break;
                }
                if (j + 1 == boardLength - 1) {
                    winner += pieces[0][i].getType();
                }
            }
        }
        // Diagonals
        for (int i = 0; i < boardLength - 1; i++) {
            if (!pieces[i][i].equals(pieces[i + 1][i + 1])) {
                break;
            }
            if (i + 1 == boardLength - 1) {
                winner += pieces[0][0].getType();
            }
        }
        for (int i = 0; i < boardLength - 1; i++) {
            if (!pieces[i][boardLength - 1 - i].equals(pieces[i + 1][boardLength - 2 - i])) {
                break;
            }
            if (i + 1 == boardLength - 1) {
                winner += pieces[0][boardLength - 1].getType();
            }
        }
        return new Piece(winner);
    }
    public boolean isFull()
    {
        for (int i = 0; i < boardLength; i++)
        {
            for (int j = 0; j < boardLength; j++)
            {
                if (pieces[i][j].equals(Piece.EMPTY))
                {
                    return false;
                }
            }
        }
        return true;
    }
}