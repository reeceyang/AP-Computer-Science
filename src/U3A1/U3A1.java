// Reece Yang
//
// This driver class will generate Dialog Boxes
// to read in a letter grade and a numeric grade
// and to display the converted grades using the
// Grade class.

import javax.swing.JOptionPane;

public class U3A1 {

	public static void main(String[] args) {

		String letterGrade;
		letterGrade =
			JOptionPane.showInputDialog("Please enter Letter Grade:");

		double numericGrade;
		numericGrade = Double.parseDouble(
				JOptionPane.showInputDialog("Please enter Numeric Grade:"));

		Grade g = new Grade(letterGrade, numericGrade);

		JOptionPane.showMessageDialog(null,
			"Numeric Grade Equivalent = " + g.getNewNumeric() +
			"\n\nLetter Grade Equivalent = " + g.getNewLetter(),
			"U3A1", JOptionPane.INFORMATION_MESSAGE);
	}
}