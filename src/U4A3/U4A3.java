// Reece Yang
//
// This applet driver class creates a salary schedule for teachers at any
// school.

import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Container;
import java.awt.Font;

public class U4A3 extends JApplet {

	public void init() {

		String p1 = "Enter Base Salary (10000 - 50000),\n";
		String p2 = "Enter Number of Lanes (3 - 6),\n";
		String p3 = "Enter Number of Steps per Lane (10 - 20)\n\n";
		String p4 = "(Separate the numbers with single spaces)";

		String input = JOptionPane.showInputDialog(p1 + p2 + p3 + p4);

		int baseSalary = Integer.parseInt(input.substring(0, 5));
		int lanes = Integer.parseInt(input.substring(6, 7));
		int steps = Integer.parseInt(input.substring(8, 10));

		JTextArea out = new JTextArea();
		out.setFont(new Font("Monospaced", Font.BOLD, 16));

		out.append("\t\tSalary Schedule\n");
		out.append("\n\t");

		for (int i = 1; i <= lanes; i++) {

			out.append("  " + i + "  \t");
		}

		out.append("\n\n");

		int stepSalary = baseSalary;
		for (int i = 1; i <= steps; i++) {

			out.append(i + "\t");
			int laneSalary = stepSalary;
			for (int j = 1; j <= lanes; j++) {

				out.append(laneSalary + "\t");
				laneSalary += (laneSalary * 9) / 100;
			}
			stepSalary += (stepSalary * 3) / 100;
			out.append("\n");
		}

		Container c = getContentPane();
		c.add(out);
	}
}