// Reece Yang
//
// This is a driver class for the DataSet class.

import java.util.Scanner;

public class U2Test {

	public static void main(String[] args) {

		DataSet a = new DataSet();
		DataSet b = new DataSet(73, 8);

		Scanner in = new Scanner(System.in);

		System.out.print("Enter Integer #1: ");
		int v1 = in.nextInt();
		a.addValue(v1);
		b.addValue(v1);

		System.out.print("Enter Integer #2: ");
		int v2 = in.nextInt();
		a.addValue(v2);
		b.addValue(v2);

		System.out.print("Enter Integer #3: ");
		int v3 = in.nextInt();
		a.addValue(v3);
		b.addValue(v3);

		System.out.print("Enter Integer #4: ");
		int v4 = in.nextInt();
		a.addValue(v4);
		b.addValue(v4);

		System.out.println();

		System.out.printf("Default Constructor Average    = %.1f\n\n", a.average());
		System.out.printf("Paremetric Constructor Average = %.1f\n", b.average());
	}
}

/*

Enter Integer #1: 45
Enter Integer #2: 32
Enter Integer #3: 66
Enter Integer #4: 4

Default Constructor Average    = 36.8

Paremetric Constructor Average = 18.3

*/