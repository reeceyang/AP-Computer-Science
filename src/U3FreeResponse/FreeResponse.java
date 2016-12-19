
import java.util.Scanner;


public class FreeResponse {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		/*while (true) {

			int hours = in.nextInt();
			double rate = in.nextDouble();

			System.out.println(detPay(hours, rate));
		}*/

		while (true) {

			compSqrtPow(in.nextDouble());
		}
	}

	public static double detPay(int hours, double rate) {

		return hours <= 40 ? hours * rate : (hours - 40) * 1.5 * rate + rate * 40;

	}

	public static void compSqrtPow(double num) {

		System.out.println(Math.sqrt(num)==Math.pow(num, 0.5)?"Same":"Different");
	}

}