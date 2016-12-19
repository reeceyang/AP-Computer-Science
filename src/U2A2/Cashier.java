// Reece Yang
//
// This class models a cashier.

public class Cashier {

	// Instance fields
	private int dollars, quarters, dimes, nickels, pennies;

	// Paremetric constructor accepts the amount due
	// and the amount received, determinates the difference
	// between the two, and initializes the five instance fields
	public Cashier(double due, double received) {

		int difference = (int) Math.round(received * 100.0 - due * 100.0);

		dollars = (difference - (difference % 100)) / 100;
		difference = difference % 100;

		quarters = (difference - (difference % 25)) / 25;
		difference = difference % 25;

		dimes = (difference - (difference % 10)) / 10;
		difference = difference % 10;

		nickels = (difference - (difference % 5)) / 5;
		difference = difference % 5;

		pennies = difference;
	}

	// Accessor methods
	public int getDollars() {

		return dollars;
	}

	public int getQuarters() {

		return quarters;
	}
	public int getDimes() {

		return dimes;
	}
	public int getNickels() {

		return nickels;
	}
	public int getPennies() {

		return pennies;
	}
}