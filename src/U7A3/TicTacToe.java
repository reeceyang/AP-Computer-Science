// Reece Yang
//
// This is a Tic-Tac-Toe game.

package U7A3;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class TicTacToe extends JFrame
{
    private JButton[] cells;
    private JButton quitButton;
    private JButton newGameButton;
    private JTextField jumbotron;
    private Board board;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu editMenu;
    private JMenu helpMenu;
    private JPanel windowPanel;
    private JPanel cellPanel;
    private int turn;
    private static int BOARD_LENGTH = 3;

    public TicTacToe()
    {
        windowPanel = new JPanel();
        BorderLayout borderLayout = new BorderLayout();
        windowPanel.setLayout(borderLayout);

        setMenuBar();
        setJumbotronPanel();
        setCellPanel();
        setFrame();
        jumbotron.setText("X's Turn");
    }

    private void setFrame()
    {
        setContentPane(windowPanel);
        setJMenuBar(menuBar);
        setTitle("Tic-Tac-Toe");
        setSize(600, 700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void setCellPanel()
    {
        // Construct and set GridLayout layout manager
        cellPanel = new JPanel();
        GridLayout gL2 = new GridLayout(BOARD_LENGTH, BOARD_LENGTH);
        cellPanel.setLayout(gL2);

        // Set turn to 1
        turn = 1;

        cells = new JButton[BOARD_LENGTH * BOARD_LENGTH];
        board = new Board(BOARD_LENGTH);
        class CellActionListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                JButton clickedButton = (JButton) e.getSource();
                if (clickedButton.getText().equals("X") || clickedButton.getText().equals("O"))
                {/* The cell is filled, do nothing */}
                else
                {
                    // The cell is empty
                    // Find which button was clicked
                    int clickedButtonHashCode = clickedButton.hashCode();
                    int index;
                    for (index = 0; index < BOARD_LENGTH * BOARD_LENGTH; index++) {
                        if (clickedButtonHashCode == cells[index].hashCode()) {
                            // The clicked button is cells[index]
                            break;
                        }
                    }
                    // Find out who's turn it is
                    Piece mover = turn % 2 == 1 ? Piece.X : Piece.O;
                    // Set the clicked button's text to that piece
                    cells[index].setText(mover.toString());
                    // Place the piece in the corresponding cell on the board
                    board.place(index / BOARD_LENGTH, index % BOARD_LENGTH, mover);
                    // Check for a winner
                    Piece winner = board.checkForWin();
                    // If there is no winner and the board isn't full
                    if (winner.equals(Piece.EMPTY) && !board.isFull())
                    {
                        // Next turn
                        jumbotron.setText((mover.toString().equals("X") ? "O" : "X")
                                + jumbotron.getText().substring(1));
                        turn++;
                    }
                    else
                    {
                        // Find out if it's a tie or if X or O won
                        String message = winner.equals(Piece.EMPTY) ?
                                        "The game has tied."
                                        : winner + " has won the game.";
                        // Show option dialog with quit and new game choices
                        Object[] choices = {"Quit", "New Game"};
                        int chosen = JOptionPane.showOptionDialog(null,
                                message,
                                "Tic-Tac-Toe",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                choices,
                                choices[1]);
                        if (chosen == 0)
                        {
                            quit();
                        }
                        else
                        {
                            newGame();
                        }
                    }
                }
            }
        }
        for (int i = 0; i < BOARD_LENGTH * BOARD_LENGTH; i++)
        {
            cells[i] = new JButton("");
            ActionListener cellListener = new CellActionListener();
            cells[i].addActionListener(cellListener);
            cellPanel.add(cells[i]);
        }
        windowPanel.add("Center", cellPanel);
    }

    private void setMenuBar()
    {
        menuBar = new JMenuBar();
        // A recyclable menu item
        JMenuItem menuItem;

        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        menuItem = new JMenuItem("New Game", KeyEvent.VK_N);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Start a new game");
        class NewGameActionListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                newGame();
            }
        }
        menuItem.addActionListener(new NewGameActionListener());
        fileMenu.add(menuItem);
        menuItem = new JMenuItem("Export Game", KeyEvent.VK_E);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Export the current game");
        class ExportGameActionListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                export();
            }
        }
        menuItem.addActionListener(new ExportGameActionListener());
        fileMenu.add(menuItem);
        fileMenu.addSeparator();
        menuItem = new JMenuItem("Quit", KeyEvent.VK_Q);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Quit the game");
        class QuitActionListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                quit();
            }
        }
        menuItem.addActionListener(new QuitActionListener());
        fileMenu.add(menuItem);
        menuBar.add(fileMenu);

        editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E);
        menuBar.add(editMenu);

        helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        menuItem = new JMenuItem("About", KeyEvent.VK_A);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_A, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "About Tic-Tac-Toe");
        class AboutActionListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(null,
                        "Tic-Tac-Toe v1.0 \u00a9 Reece Yang 2017");
            }
        }
        menuItem.addActionListener(new AboutActionListener());
        helpMenu.add(menuItem);
        menuBar.add(helpMenu);
    }

    private void setJumbotronPanel()
    {
        jumbotron = new JTextField(30);
        jumbotron.setHorizontalAlignment(JTextField.CENTER);
        jumbotron.setEditable(false);
        windowPanel.add("North", jumbotron);
    }

    private void refreshBoard()
    {
        for (int i = 0; i < BOARD_LENGTH * BOARD_LENGTH; i++)
        {
            cells[i].setText(board.getPiece(i / BOARD_LENGTH, i % BOARD_LENGTH).toString());
        }
    }

    private void newGame()
    {
        board.clear();
        refreshBoard();
        turn = 1;
        jumbotron.setText("X's Turn");
    }

    private void quit()
    {
        System.exit(0);
    }

    private void export()
    {
        try
        {
            FileWriter writer = new FileWriter("src/U7A3/board.brd");
            PrintWriter out = new PrintWriter(writer);
            out.println(board.toString());
            out.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e.toString());
        }
    }

    public static void main(String[] args)
    {
        TicTacToe ticTacToe = new TicTacToe();
    }
}
