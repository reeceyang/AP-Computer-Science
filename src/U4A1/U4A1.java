// Reece Yang
//
// This applet is a driver class that inputs binary numbers using a sentinel
// controlled loop and converts them to decimal numbers using the Binary class

import javax.swing.JApplet;
import javax.swing.JOptionPane;
import java.awt.Container;
import javax.swing.JTextArea;
import java.awt.Font;

public class U4A1 extends JApplet {

  public void init() {

	JTextArea output = new JTextArea();
	output.setFont(new Font("Monospaced", Font.BOLD, 12));
	output.append("Results of U4A1\n\n\n");
	output.setTabSize(6);

    String number = "";
	int count = 0;
	int sum = 0;

    while (!number.equals("-1")) {

		number = JOptionPane.showInputDialog("Enter Binary Number:");
		if (!number.equals("-1")) {

			Binary b = new Binary(number);
			count++;
			output.append("Number " + count + ": " + number + " =\t\t" + b.convert() + "\n");
			sum += b.convert();
		}
    }

    output.append("\n\n");
    output.append("Number of Numbers = " + count + "\n");
    output.append("Accumulated Value = " + sum + "\n");
    output.append("Mean              = " + String.format("%.2f", (sum + 0.0)/count));

    Container c = getContentPane();
    c.add(output);

  }
}
