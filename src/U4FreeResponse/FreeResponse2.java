public class FreeResponse2 {

	public static void main(String[] args) {

		double pop = 89.2e6;
		int year = 1991;
		System.out.println("Year: " + year);
		System.out.println("Population: " + pop);
		while (pop < 120e6) {

			pop *=	1.023;
			year++;
			System.out.println("Year: " + year);
			System.out.println("Population: " + pop);
		}
	}
}