// Reece Yang
//
// This Java project (application) programs the Game of Life

package U5A4;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Container;
import java.awt.Font;

public class GameOfLife extends JFrame
{
    private JTextArea out;
    private String board[][] = {{" ", " ", " ", " ", " ", " "},
                                {" ", " ", "*", " ", " ", " "},
                                {" ", " ", " ", "*", " ", " "},
                                {" ", "*", "*", "*", " ", " "},
                                {" ", " ", " ", " ", " ", " "},
                                {" ", " ", " ", " ", " ", " "}};

    public GameOfLife()
    {
        Container container = getContentPane();
        out = new JTextArea();
        out.setFont(new Font("Monospaced", Font.PLAIN, 16));
        container.add(out);

        out.append("Generation 0\n");
        printBoard();

        createNextGeneration();
        createNextGeneration();
        out.append("Generation 2\n");
        printBoard();

        createNextGeneration();
        createNextGeneration();
        out.append("Generation 4\n");
        printBoard();

        setSize(200, 1000);
        setVisible(true);
    }

    private void printBoard()
    {
        for (int j = 0; j < 6; j++)
        {
            out.append("|");
            for (int k = 0; k < 6; k++)
            {
                out.append(board[j][k] + "|");
            }
            out.append("\n");
            out.append("-------------\n");
        }
    }

    private void createNextGeneration()
    {
        String[][] temp = new String[6][6];
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                int neighbors = neighbors(i, j);
                if (neighbors == 3)
                {
                    temp[i][j] = "*";
                }
                else if (neighbors >= 4 || neighbors <= 1)
                {
                    temp[i][j] = " ";
                }
                else
                {
                    temp[i][j] = board[i][j];
                }
            }
        }
        board = temp;
    }

    private int neighbors(int row, int col)
    {
        int neighbors = 0;
        for (int i = -1; i <= 1; i++)
        {
            for (int j = -1; j <= 1; j++)
            {
                try
                {
                    if (i != 0 || j != 0)
                    {
                        if (board[row + i][col + j].equals("*"))
                        {
                            neighbors++;
                        }
                    }
                }
                catch (RuntimeException e) {}
            }
        }
        return neighbors;
    }

    public static void main(String[] args)
    {
        GameOfLife game = new GameOfLife();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
