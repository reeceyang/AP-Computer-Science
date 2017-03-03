// Reece Yang
//
// This is a Tic-Tac-Toe game.

package U7A3;

import java.io.IOException;
import java.util.Scanner;

public class TicTacToe
{
    private int boardLength;
    private Board board;
    private int turn = 1;

    public TicTacToe()
    {
        boardLength = 3;
        board = new Board(boardLength, boardLength);
        turn = 1;
        clearBoard();
        board.drawBoard();
        while (!isEndPosition())
        {
            getAndHandleInput();
            board.drawBoard();
            turn++;
        }
        Piece winner = checkForWin();
        String message = winner.getID().equals(" ") ? "The game has tied (Cats Game)."
                : winner.getID() + " has won the game.";
        System.out.println(message);
        System.out.print("Press enter to quit.");
        try
        {
            System.in.read();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e.toString());
        }
    }
    public void clearBoard()
    {
        for (int i = 0; i < boardLength; i++)
        {
            for (int j = 0; j < boardLength; j++)
            {
                board.addPiece(new Piece(), i, j);
            }
        }
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
                if (j + 1 == boardLength - 1 && !pieces[i][0].equals(new Piece()))
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
                if (j + 1 == boardLength - 1 && !pieces[0][i].equals(new Piece()))
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
            if (i + 1 == boardLength - 1 && !pieces[0][0].equals(new Piece()))
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
            if (i + 1 == boardLength - 1 && !pieces[0][boardLength - 1].equals(new Piece()))
            {
                return pieces[0][boardLength - 1];
            }
        }
        return new Piece();
    }
    public boolean checkIfBoardIsFull()
    {
        if (getNumberOfNonEmptyPieces() != boardLength * boardLength) {
            return false;
        }
        return true;
    }
    public boolean isEndPosition()
    {
        Piece winner = checkForWin();
        if (!winner.equals(new Piece()) || checkIfBoardIsFull())
        {
            return true;
        }
        return false;
    }
    public int getNumberOfNonEmptyPieces()
    {
        int nonEmptyPieces = 0;
        for (int i = 0; i < boardLength; i++)
        {
            for (int j = 0; j < boardLength; j++)
            {
                if (board.isOccupied(i, j))
                {
                    nonEmptyPieces++;
                }
            }
        }
        return nonEmptyPieces;
    }
    public void getAndHandleInput()
    {
        Piece piece = turn % 2 == 1 ? new Piece("X") : new Piece("O");
        int row = 0, col = 0;
        Scanner in = new Scanner(System.in);
        boolean inputValid = false;
        while (!inputValid)
        {
            System.out.print("Please enter the row and column, respectively,"
                    + " separated by a space, where you wish to place your piece: ");
            row = in.nextInt();
            col = in.nextInt();
            if (board.isOccupied(row, col))
            {
                System.out.println("Sorry, that position has been taken.");
            }
            else
            {
                inputValid = true;
            }
        }
        board.addPiece(piece, row, col);
    }
    public static void main(String[] args)
    {
        TicTacToe ticTacToe = new TicTacToe();
    }
}
