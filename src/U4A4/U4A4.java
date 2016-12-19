// Reece Yang
//
// This Java application calculates the number of months needed to pay off
// debt and the profit for the credit card company given the credit card
// balance, the minimum monthly payment, and the annual percentage rate.

import java.util.Scanner;

public class U4A4 {

	int balance;
	int monthlyPayment;
	int apr;
	int months;
	double profit;

	public static void main(String[] args) {

		U4A4 u = new U4A4();
	}


	public U4A4() {

		Scanner in = new Scanner(System.in);

		System.out.print("Enter credit card balance: ");
		balance = in.nextInt();

		System.out.print(
			"\nEnter minimum monthly payment (as a % of the balance): ");
		monthlyPayment = in.nextInt();

		System.out.print("\nEnter the annual percentage rate: ");
		apr = in.nextInt();

		months = 0;
		profit = -balance;

		months = getMonths(balance);

		System.out.println("\n\nNumber of months to pay off debt: " + months);
		System.out.printf(
				"\nProfit for the credit card company = $%.2f\n", profit);
	}

	public int getMonths(double bal) {

		double nextBal;
		months++;

		double payment = bal * (monthlyPayment/100.0);

		if (payment < 20 && bal < 20) {

			nextBal = 0;
			profit += bal;
		}
		else if (payment < 20 && bal >= 20) {

			nextBal = bal * (1 + apr/1200.0) - 20;
			profit += 20;
		}
		else {

			nextBal = bal * (1 + apr/1200.0) - payment;
			profit += payment;
		}

		if (nextBal == 0) {

			return months;
		}
		else {

			return getMonths(nextBal);
		}
	}
}

/*

Enter credit card balance: 1200

Enter minimum monthly payment (as a % of the balance): 4

Enter the annual percentage rate: 18


Number of months to pay off debt: 67

Profit for the credit card company = $551.30

*/

/*

Enter credit card balance: 1200

Enter minimum monthly payment (as a % of the balance): 2

Enter the annual percentage rate: 18


Number of months to pay off debt: 130

Profit for the credit card company = $1462.08

*/

/*

Enter credit card balance: 1200

Enter minimum monthly payment (as a % of the balance): 2

Enter the annual percentage rate: 21


Number of months to pay off debt: 193

Profit for the credit card company = $2797.01

*/