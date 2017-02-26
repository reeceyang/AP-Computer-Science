// Reece Yang
//
// This is a Tic-Tac-Toe game.

package U7A3;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicTacToe extends JFrame
{
    private final JButton[] cells;
    private final JButton quitButton;
    private final JButton newGameButton;
    private final JTextField jumbotron;
    private final Board board;
    private JPanel jumbotronPanel;
    private JPanel windowPanel;
    private JPanel cellPanel;
    private static final int BOARD_LENGTH = 3;

    public TicTacToe()
    {
        windowPanel = new JPanel();
        BorderLayout borderLayout = new BorderLayout();
        windowPanel.setLayout(borderLayout);

        jumbotronPanel = new JPanel();
        GridLayout gL1 = new GridLayout(1, 3);
        jumbotronPanel.setLayout(gL1);

        quitButton = new JButton("Quit");
        class QuitActionListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        }
        ActionListener quitListener = new QuitActionListener();
        quitButton.addActionListener(quitListener);
        jumbotronPanel.add(quitButton);

        jumbotron = new JTextField(30);
        jumbotronPanel.add(jumbotron);

        newGameButton = new JButton("New Game");
        class NewGameActionListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                newGame();
            }
        }
        ActionListener newGameListener = new NewGameActionListener();
        newGameButton.addActionListener(newGameListener);
        jumbotronPanel.add(newGameButton);

        windowPanel.add("North", jumbotronPanel);

        cellPanel = new JPanel();
        GridLayout gL2 = new GridLayout(BOARD_LENGTH, BOARD_LENGTH);
        cellPanel.setLayout(gL2);

        cells = new JButton[BOARD_LENGTH * BOARD_LENGTH];
        board = new Board(BOARD_LENGTH);
        class CellActionListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                JButton clickedButton = (JButton) e.getSource();
                if (clickedButton.getText().equals("X") || clickedButton.getText().equals("O"))
                {/* Do nothing */}
                else
                {
                    int clickedButtonHashCode = clickedButton.hashCode();
                    int index;
                    for (index = 0; index < BOARD_LENGTH * BOARD_LENGTH; index++) {
                        if (clickedButtonHashCode == cells[index].hashCode()) {
                            break;
                        }
                    }
                    String mover = jumbotron.getText().charAt(0) + "";
                    cells[index].setText(mover);
                    board.place(index / BOARD_LENGTH, index % BOARD_LENGTH, new Piece(Piece.stringToType(mover)));
                    Piece winner = board.checkForWin();
                    if (winner.equals(new Piece(Piece.EMPTY)))
                    {
                        jumbotron.setText((mover.equals("X") ? "O" : "X") + jumbotron.getText().substring(1));
                    }
                    else
                    {
                        Object[] choices = {"Quit", "New Game"};
                        int chosen = JOptionPane.showOptionDialog(null,
                                winner + " has won the game.",
                                "Tic-Tac-Toe",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                choices,
                                choices[1]);
                        if (chosen == 0)
                        {
                            System.exit(0);
                        }
                        else
                        {
                            newGame();
                        }
                    }
                }
                //jumbotron.setText("Cell Clicked. Cell Row: " + index / 3 + " Cell Col: " + index % 3);
            }
        }
        for (int i = 0; i < 9; i++)
        {
            cells[i] = new JButton("");
            ActionListener cellListener = new CellActionListener();
            cells[i].addActionListener(cellListener);
            cellPanel.add(cells[i]);
        }
        windowPanel.add("Center", cellPanel);

        jumbotron.setText("X's Turn");

        setContentPane(windowPanel);
        setTitle("Tic-Tac-Toe");
        setSize(600, 700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void refreshBoard()
    {
        for (int i = 0; i < BOARD_LENGTH * BOARD_LENGTH; i++)
        {
            cells[i].setText(board.getPiece(i / BOARD_LENGTH, i % BOARD_LENGTH).toString());
        }
    }

    public void newGame()
    {
        board.clear();
        refreshBoard();
        jumbotron.setText("X's Turn");
    }

    public static void main(String[] args)
    {
        TicTacToe ticTacToe = new TicTacToe();
    }
}
