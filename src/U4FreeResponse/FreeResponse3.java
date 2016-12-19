public class FreeResponse3 {

	public static void main(String[] args) {

		System.out.println(myGPA("FBCDABAAABBAAABAAACA"));
	}

	public static double myGPA(String grades) {

		int length = grades.length();
		int sum = 0;
		for (int i = 0; i < length; i++) {

			char letter = grades.charAt(i);
			if (letter == 'A') {

				sum += 4;
			}
			if (letter == 'B') {

				sum += 3;
			}
			if (letter == 'C') {

				sum += 2;
			}
			if (letter == 'D') {

				sum++;
			}
		}
		return sum / (double) length;
	}
}