// Reece Yang
//
// This project will draw two Rectangles on an applet
// and fill in their intersection

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.applet.Applet;

public class U1A2b extends Applet {

	public void init(){

		// Set background color to yellow
		setBackground(Color.yellow);
	}

	public void paint(Graphics g){

		// Constructs two rectangles
		Rectangle one = new Rectangle(5, 10, 50, 80);
		Rectangle two = new Rectangle(20, 50, 65, 55);

		// Sets color to blue
		g.setColor(Color.blue);

		// Draws the rectangles
		g.drawRect((int) one.getX(), (int) one.getY(), (int) one.getWidth(), (int) one.getHeight());
		g.drawRect((int) two.getX(), (int) two.getY(), (int) two.getWidth(), (int) two.getHeight());

		// Determines their intersection
		Rectangle intersection = one.intersection(two);

		// Sets color to red
		g.setColor(Color.red);

		// Draws the intersection
		g.fillRect((int) intersection.getX(), (int) intersection.getY(), (int) intersection.getWidth(), (int) intersection.getHeight());
	}


}

