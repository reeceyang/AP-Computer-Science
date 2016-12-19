// Reece Yang
//
// This driver class is an Applet
// that uses the Month class to convert
// an integer into its corresponding month.

import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Container;

public class U3A3 extends JApplet {

	public void init() {

		// Get month number
		int month;
		month = Integer.parseInt(
			JOptionPane.showInputDialog(
			"Please enter month as a number:"));

		// Set month name
		String name = "";

		switch (month) {

			case 1:
				name = "January";
				break;
			case 2:
				name = "February";
				break;
			case 3:
				name = "March";
				break;
			case 4:
				name = "April";
				break;
			case 5:
				name = "May";
				break;
			case 6:
				name = "June";
				break;
			case 7:
				name = "July";
				break;
			case 8:
				name = "August";
				break;
			case 9:
				name = "September";
				break;
			case 10:
				name = "October";
				break;
			case 11:
				name = "November";
				break;
			case 12:
				name = "December";
				break;
		}

		// Construct month
		Month m = new Month(month);

		// Make output
		String result = "The month of " + name + " has "
			+ m.getDays() + " days.";

		// Set the output to the JTextArea
		JTextArea out = new JTextArea();
		out.setText(result);

		// Add JTextArea to the container
		Container container = getContentPane();
		container.add(out);
	}

}