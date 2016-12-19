// Reece Yang
//
// This class simulates a simplified version of the Iowa Lottery Game.

package U5A2;

public class Lottery {

	private int[] numbers;
	private int powerBall;

	public Lottery() {

		numbers = new int[5];
		powerBall = (int)(35 * Math.random() + 1);

		int[] choices = new int[59];
		for (int i = 0; i < 59; i++) {

			choices[i] = i + 1;
		}

		int n;
		// fill numbers array
		for (int i = 0; i < 5; i++) {

			do {

				n = (int)(59 * Math.random());
			} while (choices[n] == 0);

			numbers[i] = choices[n];
			choices[n] = 0;
		}
	}
	public int check(int[] nums, int pb) {

		int matches = 0;
		int won = 0;

		// if the powerball matches
		if (pb == powerBall) {

			for (int i = 0; i < 5; i++) {

				for (int j = 0; j < 5; j++) {

					if (numbers[i] == nums[j]) {

						matches++;
					}
				}
			}
			switch (matches) {

				case 5:
					won = 1000000;
					break;
				case 4:
					won = 10000;
					break;
				case 3:
					won = 100;
					break;
				case 2:
					won = 7;
					break;
				case 1:
					won = 4;
					break;
				case 0:
					won = 4;
					break;
			}
		} else {

			// if the powerball doesn't match

			for (int i = 0; i < 5; i++) {

				for (int j = 0; j < 5; j++) {

					if (numbers[i] == nums[j]) {

						matches++;
					}
				}
			}

			switch (matches) {

				case 5:
					won = 500000;
					break;
				case 4:
					won = 100;
					break;
				case 3:
					won = 7;
					break;
			}
		}
		return won;
	}
	public int[] getNumbers() {

		return numbers;
	}
	public int getPowerBall() {

		return powerBall;
	}
}