// Reece Yang
//
// This is a driver class for the Lottery class.

package U5A2;

public class U5A2 {

    public static void main(String[] args) {

        Lottery lot = new Lottery();
        int win4 = 0;
        int win7 = 0;
        int win100 = 0;
        int win10000 = 0;
        int win500000 = 0;
        int win1000000 = 0;
        int player;

        System.out.println("This Week's Numbers Are:");
        int[] nums = lot.getNumbers();
        for (int i = 0; i < 5; i++) {

            System.out.print(nums[i] + " ");
        }
        System.out.print(lot.getPowerBall());
        System.out.println("\n");

        for (player = 1; player <= 1e6; player++) {

            int[] numbers = new int[5];
            int powerBall = (int)(35 * Math.random() + 1);

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
            int won = lot.check(numbers, powerBall);
            switch (won) {

                case 4:
                    win4++;
                    break;
                case 7:
                    win7++;
                    break;
                case 100:
                    win100++;
                    break;
                case 10000:
                    win10000++;
                    break;
                case 500000:
                    win500000++;
                    break;
                case 1000000:
                    win1000000++;
                    break;
            }
            if (won >= 10000) {

                System.out.println("Player #" + player + " wins: $" + won);
                for (int i = 0; i < 5; i++) {

                    System.out.print(numbers[i] + " ");
                }
                System.out.print(powerBall);
                System.out.println("\n");
            }
        }
        System.out.println("$4 Winners:         " + win4);
        System.out.println("$7 Winners:         " + win7);
        System.out.println("$100 Winners:       " + win100);
        System.out.println("$10,000 Winners:    " + win10000);
        System.out.println("$500,000 Winners:   " + win500000);
        System.out.println("$1,000,000 Winners: " + win1000000);
    }
}

/*

This Week's Numbers Are:
43 4 12 38 13 27

Player #204969 wins: $10000
43 7 4 13 38 27

Player #334141 wins: $10000
43 12 38 6 4 27

Player #581345 wins: $500000
38 13 12 43 4 16

Player #707009 wins: $10000
45 43 12 38 4 27

$4 Winners:         26865
$7 Winners:         4251
$100 Winners:       121
$10,000 Winners:    3
$500,000 Winners:   1
$1,000,000 Winners: 0

*/