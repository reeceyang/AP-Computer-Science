// Reece Yang
//
// This is a Tic-Tac-Toe game.

package U7A3;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
    private JPanel jumbotronPanel;
    private JPanel windowPanel;
    private JPanel cellPanel;

    public TicTacToe()
    {
        windowPanel = new JPanel();
        BorderLayout borderLayout = new BorderLayout();
        windowPanel.setLayout(borderLayout);

        jumbotronPanel = new JPanel();
        GridLayout gL1 = new GridLayout(1, 3);
        jumbotronPanel.setLayout(gL1);

        quitButton = new JButton("Quit");
        class quitActionListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        }
        ActionListener quitListener = new quitActionListener();
        quitButton.addActionListener(quitListener);
        jumbotronPanel.add(quitButton);

        jumbotron = new JTextField(30);
        jumbotronPanel.add(jumbotron);

        newGameButton = new JButton("New Game");
        class newGameActionListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                jumbotron.setText("New Game Started");
            }
        }
        ActionListener newGameListener = new newGameActionListener();
        newGameButton.addActionListener(newGameListener);
        jumbotronPanel.add(newGameButton);

        windowPanel.add("North", jumbotronPanel);

        cellPanel = new JPanel();
        GridLayout gL2 = new GridLayout(3, 3);
        cellPanel.setLayout(gL2);

        cells = new JButton[9];
        for (int i = 0; i < 9; i++)
        {
            cells[i] = new JButton("");
            cellPanel.add(cells[i]);
        }
        windowPanel.add("Center", cellPanel);

        setContentPane(windowPanel);
        setSize(600, 700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        TicTacToe ticTacToe = new TicTacToe();
    }
}
