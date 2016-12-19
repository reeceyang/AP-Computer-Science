// Reece Yang
//
// This is a driver class that will determine
// the time a worker spends on a task and
// how much the worker should be paid by using
// the TimeInterval class.

import java.util.Scanner;

public class U2A3 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.print("Please enter the starting time: ");
		String startingTime = in.nextLine();
		System.out.print("Please enter the finishing time: ");
		String endingTime = in.nextLine();
		System.out.print("Please enter the rate of pay: ");
		double payRate = Double.parseDouble(in.nextLine());
		System.out.println();

		TimeInterval t = new TimeInterval(startingTime, endingTime, payRate);
		System.out.println("Time on Task = " + t.getHours() + " hours " + t.getMinutes() + " minutes\n");
		System.out.printf("Pay = $%.2f\n", t.getPay());
	}
}

/*

Please enter the starting time: 0930
Please enter the finishing time: 1700
Please enter the rate of pay: 12.75

Time on Task = 7 hours 30 minutes

Pay = $95.63

*/