public class FreeResponse4 {

	public static void main(String[] args) {

		myFactors();
	}

	public static void myFactors() {

		System.out.println("Number\tFactors");
		System.out.println("------\t-------");

		for (int i = 30; i <= 50; i++) {

			System.out.print("" + i + "\t");
			for (int j = 1; j <= i - 1; j++) {

				if (i % j == 0) {

					System.out.print("" + j + ", ");
				}
			}
			System.out.print("" + i + "\n");
		}
	}
}