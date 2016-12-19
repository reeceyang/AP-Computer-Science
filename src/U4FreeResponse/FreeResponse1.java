public class FreeResponse1 {

	public static void main(String[] args) {

		for (int i = 1; i <= 4; i++) {

			for (int j = 0; j < i - 1; j++) {

				System.out.print("-");
			}
			System.out.print("" + i * 2);
			for (int j = 0; j < 6 - i; j++) {

				System.out.print("-");
			}
			System.out.print("\n");
		}
	}
}