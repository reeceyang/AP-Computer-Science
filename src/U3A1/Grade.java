// Reece Yang
//
// This class converts a letter grade
// to a numeric grade and a numeric grade
// to a letter grade.

public class Grade {

	private String origLetter;
	private String newLetter;
	private double origNumeric;
	private double newNumeric;

	public Grade(String stringGrade, double numericGrade) {

		origLetter = stringGrade;
		origNumeric = numericGrade;

		setNewLetter();
		setNewNumeric();
	}

	public void setNewLetter() {

		if (origNumeric == 4.0) {

			newLetter = "A+";
		}
		if (origNumeric >= 3.85 && origNumeric <= 3.99) {

			newLetter = "A";
		}
		if (origNumeric >= 3.5 && origNumeric <= 3.84) {

			newLetter = "A-";
		}
		if (origNumeric >= 3.15 && origNumeric <= 3.49) {

			newLetter = "B+";
		}
		if (origNumeric >= 2.85 && origNumeric <= 3.14) {

			newLetter = "B";
		}
		if (origNumeric >= 2.5 && origNumeric <= 2.84) {

			newLetter = "B-";
		}
		if (origNumeric >= 2.15 && origNumeric <= 2.49) {

			newLetter = "C+";
		}
		if (origNumeric >= 1.85 && origNumeric <= 2.14) {

			newLetter = "C";
		}
		if (origNumeric >= 1.5 && origNumeric <= 1.84) {

			newLetter = "C-";
		}
		if (origNumeric >= 1.15 && origNumeric <= 1.49) {

			newLetter = "D+";
		}
		if (origNumeric >= 0.85 && origNumeric <= 1.14) {

			newLetter = "D";
		}
		if (origNumeric >= 0.5 && origNumeric <= 0.84) {

			newLetter = "D-";
		}
		if (origNumeric >= 0.0 && origNumeric <= 0.49) {

			newLetter = "F";
		}
	}

	public void setNewNumeric() {

		newNumeric = 0.0;

		if (origLetter.substring(0,1).equals("A")) {

			newNumeric += 4.0;
		}
		if (origLetter.substring(0,1).equals("B")) {

			newNumeric += 3.0;
		}
		if (origLetter.substring(0,1).equals("C")) {

			newNumeric += 2.0;
		}
		if (origLetter.substring(0,1).equals("D")) {

			newNumeric += 1.0;
		}
		if (origLetter.length() > 1) {

			if (origLetter.substring(1,2).equals("+")
				&& !origLetter.substring(0,1).equals("A")) {

				newNumeric += 0.3;
			}
			if (origLetter.substring(1,2).equals("-")) {

				newNumeric -= 0.3;
			}
		}
	}

	public String getNewLetter() {

		return newLetter;
	}

	public double getNewNumeric() {

		return newNumeric;
	}
}