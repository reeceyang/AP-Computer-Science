// Reece Yang
//
// This is a driver class for the EasterSunday class
// that will find the Easter Sunday for 2016 and 2017

import java.io.*;
import java.util.Scanner;

public class U2A4 {

	public static void main(String[] args) {

		U2A4 u = new U2A4();
	}

	public U2A4() {

		Scanner in = new Scanner(System.in);
		System.out.print("Enter the year: ");
		int year = in.nextInt();

		EasterSunday e = new EasterSunday(year);

		System.out.println("Easter Sunday is on " + getMonthName(e.getMonth()) + e.getDay() + ".");
	}

	public String getMonthName(int month) {

		Scanner in;

		try {

			in = new Scanner(new File("U2A4.txt"));
		}
		catch (IOException e) {

			throw new RuntimeException(e.toString());
		}

		return in.nextLine().substring((month - 1) * 9, (month - 1) * 9 + 8);
	}
}

/*

Enter the year: 2016
Easter Sunday is on March   27.

Enter the year: 2017
Easter Sunday is on April   16.

*/