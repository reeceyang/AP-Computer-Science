// Reece Yang
//
// This is a Tic-Tac-Toe game.

package U7A3;

public class TicTacToe
{
    private int boardLength;
    private Board board;

    public TicTacToe()
    {
        boardLength = 3;
        board = new Board(boardLength, boardLength);
    }

    public static void main(String[] args)
    {

    }
    public Piece checkForWin()
    {
        Piece[][] pieces = board.getBoard();
        // Horizontal
        for (int i = 0; i < boardLength; i++)
        {
            for (int j = 0; j < boardLength - 1; j++)
            {
                if (!pieces[i][j].equals(pieces[i][j + 1]))
                {
                    break;
                }
                if (j + 1 == boardLength - 1)
                {
                    return pieces[i][0];
                }
            }
        }
        // Vertical
        for (int i = 0; i < boardLength; i++)
        {
            for (int j = 0; j < boardLength - 1; j++)
            {
                if (!pieces[j][i].equals(pieces[j + 1][i]))
                {
                    break;
                }
                if (j + 1 == boardLength - 1)
                {
                    return pieces[0][i];
                }
            }
        }
        // Diagonals
        for (int i = 0; i < boardLength - 1; i++)
        {
            if (!pieces[i][i].equals(pieces[i + 1][i + 1]))
            {
                break;
            }
            if (i + 1 == boardLength - 1)
            {
                return pieces[0][0];
            }
        }
        for (int i = 0; i < boardLength - 1; i++)
        {
            if (!pieces[i][boardLength - 1 - i].equals(pieces[i + 1][boardLength - 2 - i]))
            {
                break;
            }
            if (i + 1 == boardLength - 1)
            {
                return pieces[0][boardLength - 1];
            }
        }
        return new Piece();
    }
    public boolean checkIfBoardIsFull()
    {

    }
}
