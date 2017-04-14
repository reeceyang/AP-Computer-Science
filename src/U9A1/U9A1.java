// Reece Yang
//
// This is the driver class for the Worker, HourlyWorker,
// SalariedWorker, and PieceWorker classes. It determines
// the income of three workers and prints them to a JFrame.

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Container;

public class U9A1 extends JFrame
{
	private JTextArea out;

	public U9A1()
	{
		out = new JTextArea();
		out.setFont(new Font("Monospaced", Font.BOLD, 16));

		TestHourly();
		TestSalaried();
		TestPiece();

		Container container = getContentPane();
		container.add(out);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
	}

	public void TestHourly()
	{
		HourlyWorker hourlyWorker =
			new HourlyWorker("John Doe", 9.48, 43);
		out.append("Test Hourly Worker Class\n");
		out.append("------------------------\n");
		out.append("Wage for " + hourlyWorker.getName() +
				" = $" + String.format("%.2f", hourlyWorker.Wage())
				+ "\n\n\n");
	}

	public void TestSalaried()
	{
		SalariedWorker salariedWorker =
			new SalariedWorker("Karen Jones", 25.76, 52);
		out.append("Test Salaried Worker Class\n");
		out.append("--------------------------\n");
		out.append("Wage for " + salariedWorker.getName() +
				" = $" + String.format("%.2f", salariedWorker.Wage())
				+ "\n\n\n");
	}

	public void TestPiece()
	{
		PieceWorker pieceWorker =
			new PieceWorker("Wesley Smith", 5.65, 36);
		out.append("Test Piece Worker Class\n");
		out.append("-----------------------\n");
		out.append("Wage for " + pieceWorker.getName() +
				" = $" + String.format("%.2f", pieceWorker.Wage(1025))
				+ "\n\n\n");
	}

	public static void main(String[] args)
	{
		U9A1 u9a1 = new U9A1();
	}
}