// Reece Yang
//
// This is a driver class for the Point, Line, and Rectangle classes.
// It sets the background of a JApplet to yellow and plots three
// Rectangles on the JApplet.

import java.applet.Applet;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;

public class U9A2 extends Applet
{
    public void init()
    {
        setBackground(Color.yellow);
    }

    public void paint(Graphics g)
    {
        g.setFont(new Font("Monospaced", Font.BOLD, 32));

        Rectangle r1 = new Rectangle(25, 30, 10, 5);
        Rectangle r2 = new Rectangle(75, 100, 15, 3);
        Rectangle r3 = new Rectangle(50, 200, 8, 12);

        r1.drawRect(g);
        r2.drawRect(g);
        r3.drawRect(g);
    }
}
