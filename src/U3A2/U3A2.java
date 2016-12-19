// Reece Yang
//
// This applet will act as an
// online income tax helper.

import javax.swing.JApplet;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class U3A2 extends JApplet {

	private String name;
	private double owes;

	public void init() {

		String filingStatus;
		String blind;
		String spouseBlind;
		String over65;
		String spouseOver65;
		int exemptions;
		int income;
		int taxWithheld;
		int deductions;

		// Get information from user
		name = JOptionPane.showInputDialog("Enter your name:");

		filingStatus =
			JOptionPane.showInputDialog(
			"Enter Filing Status - Single(S) or Married(M):");

		blind = JOptionPane.showInputDialog("Are you blind? Yes or No:");

		over65 = JOptionPane.showInputDialog("Are you over 65? Yes or No:");

		spouseBlind = filingStatus.equals("M") ?
			JOptionPane.showInputDialog(
			"Is your spouse blind? Yes or No:") : "";

		spouseOver65 = filingStatus.equals("M") ?
			JOptionPane.showInputDialog(
			"Is your spouse over 65? Yes or No:") : "";

		exemptions = Integer.parseInt(
			JOptionPane.showInputDialog(
			"Enter total number of exemptions:"));

		income = Integer.parseInt(
			JOptionPane.showInputDialog("Enter wages, salaries, & tips:"));

		taxWithheld = Integer.parseInt(
			JOptionPane.showInputDialog("Enter Income Tax Withheld:"));

		// Calculate deductions
		deductions = exemptions;
		deductions += blind.equals("Yes") ? 1 : 0;
		deductions += spouseBlind.equals("Yes") ? 1 : 0;
		deductions += over65.equals("Yes") ? 1 : 0;
		deductions += spouseOver65.equals("Yes") ? 1 : 0;

		// Calculate taxable income
		income -= deductions * 1000;

		// Calculate tax
		double tax;

		if (filingStatus.equals("S")) {

			if (income <= 21450) {

				tax = 0.15 * income;
			}
			else if (income <= 51900) {

				tax = 3217.50 + 0.28 * (income - 21450);
			}
			else {

				tax = 11743.50 + 0.31 * (income - 51900);
			}
		}
		else {

			if (income <= 35800) {

				tax = 0.15 * income;
			}
			else if (income <= 86500) {

				tax = 5370 + 0.28 * (income - 35800);
			}
			else {

				tax = 19566 + 0.31 * (income - 86500);
			}
		}

		// Calculate how much the user owes
		owes = tax - taxWithheld;

		// Set background color
		setBackground(Color.gray);
	}

	public void paint(Graphics g) {

		// Display the results

		g.setColor(Color.black);

		Font f = new Font("Monospaced", Font.BOLD, 16);
		g.setFont(f);

		String results = String.format(
			((owes >= 0) ? "Owe" : "Refund Due") + " =   $%.2f",
			owes > 0 ? owes : -owes);

		g.drawString(name + ", below you will find", 10, 100);
		g.drawString("the results of your Tax Inquiry.", 10, 116);

		g.drawString(results, 72, 164);
	}

}