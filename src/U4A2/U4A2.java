// Reece Yang
//
// This driver class determines how many elements of the infinite
// series are required to find the value of pi to 5 digits.

public class U4A2 {

	private static final double PI = 3.14159;

	public static void main(String[] args) {

		double p = 0;
		int i = 0;
		do {
			p += (i % 2 == 0 ? 1 : -1) * 4 * (1.0 / (2 * (i + 1) - 1));
			i++;
		} while (Double.parseDouble(String.format("%.5f", p)) != PI);

		System.out.printf("Value of pi = %.5f\n", p);

		System.out.println("\nNumber of elements of the series = " + i);

	}

}

/*

Value of pi = 3.14159

Number of elements of the series = 130658

*/