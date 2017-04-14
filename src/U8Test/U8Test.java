// Reece Yang
//
// This is the driver class.
// It processes 100 dice tosses and 100 quiz scores.

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Container;
import java.awt.Font;

public class U8Test extends JFrame
{
	public U8Test()
	{
		JTextArea out = new JTextArea();
		out.setFont(new Font("Monospaced", Font.BOLD, 16));

		String[] diceOutcomes =
			{"2","3","4","5","6","7","8","9","10","11","12"};
		Tally diceTally = new Tally(diceOutcomes);

		String[] quizOutcomes =
			{"A", "B", "C", "D", "F"};
		Tally quizTally = new Tally(quizOutcomes);

		for (int i = 0; i < 100; i++)
		{
			diceTally.process(new Dice((int) (Math.random() * 6 + 1),
				(int) (Math.random() * 6 + 1)));
			quizTally.process(new Quiz((int) (Math.random() * 49 + 51)));
		}

		out.append("\tDice Tally\n");
		out.append("\t----------\n\n");
		out.append("Item\t\tTally\n");
		out.append("----\t\t-----\n");
		int[] diceTallied = diceTally.getTally();
		for (int i = 0; i < diceOutcomes.length; i++)
		{
			out.append(" " + diceOutcomes[i] +
				" \t\t " + diceTallied[i] + "\n");
		}
		out.append("\n\n\n");
		out.append("\tQuiz Tally\n");
		out.append("\t----------\n\n");
		out.append("Item\t\tTally\n");
		out.append("----\t\t-----\n");
		int[] quizTallied = quizTally.getTally();
		for (int i = 0; i < quizOutcomes.length; i++)
		{
			out.append(" " + quizOutcomes[i] +
				" \t\t " + quizTallied[i] + "\n");
		}
		Container container = getContentPane();
		container.add(out);
		setSize(350, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args)
	{
		U8Test u8Test = new U8Test();
	}
}