// Reece Yang
//
// This is the driver class
// for the Cashier class

import java.util.Scanner;

public class U2A2 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.print("Enter Amount Due: ");
		double due = Double.parseDouble(in.nextLine());
		System.out.print("Enter Amount Received: ");
		double received = Double.parseDouble(in.nextLine());
		System.out.println();

		Cashier c = new Cashier(due, received);

		System.out.println("Dollars  = " + c.getDollars());
		System.out.println("Quarters = " + c.getQuarters());
		System.out.println("Dimes    = " + c.getDimes());
		System.out.println("Nickels  = " + c.getNickels());
		System.out.println("Pennies  = " + c.getPennies());
	}
}

/*

Enter Amount Due: 41.35
Enter Amount Received: 50.00

Dollars  = 8
Quarters = 2
Dimes    = 1
Nickels  = 1
Pennies  = 0

*/