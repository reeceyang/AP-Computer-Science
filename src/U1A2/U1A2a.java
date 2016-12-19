// Reece Yang
//
// This program will construct three Rectangles,
// print them to the console window, then
// construct the intersection of the first Rectangle
// and the second and the intersection of the first
// and the third, then print those to the console window.

import java.awt.Rectangle;

public class U1A2a {

	public static void main(String[] args) {

		// Constructs Rectangles one, two, and three
		Rectangle one = new Rectangle(5, 10, 20, 30);
		Rectangle two = new Rectangle(10, 25, 35, 15);
		Rectangle three = new Rectangle(20, 30, 10, 25);

		// Prints them to the console window
		System.out.println(one + "\n" + two + "\n" + three + "\n");

		// Constructs the intersection of one and two
		Rectangle four = one.intersection(two);
		// Constructs the intersection of one and three
		Rectangle five = one.intersection(three);

		// Prints them to the console window
		System.out.println(four + "\n" + five);
	}
}

/*

java.awt.Rectangle[x=5,y=10,width=20,height=30]
java.awt.Rectangle[x=10,y=25,width=35,height=15]
java.awt.Rectangle[x=20,y=30,width=10,height=25]

java.awt.Rectangle[x=10,y=25,width=15,height=15]
java.awt.Rectangle[x=20,y=30,width=5,height=10]

*/