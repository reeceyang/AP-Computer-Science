
import java.util.Scanner;

public class Modulus {

	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);

		while(true) {
			System.out.println("mod = " + mod(in.nextInt(),in.nextInt()));
		}

	}

	// returns x mod y
	public static int mod(int x, int y) {

		return x-y*(x/y);
	}

}