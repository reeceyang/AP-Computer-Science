// Reece Yang
//
// This class models a line. It is a subclass of the Point class and has
// an instance field for the length of the line. It has a method to draw
// the line of a JApplet.

import java.awt.Graphics;

public class Line extends Point
{
	private int length;
    public static final int OFFSET = 12;

	public Line(int x, int y, int length)
	{
		super(x, y);
		this.length = length;
	}

	public void drawLine(Graphics g)
	{
		for (int i = 0; i < length; i++)
		{
			drawPoint(g);
            setX(getX() + OFFSET);
		}
	}

	public int getLength()
	{
		return length;
	}

	public void setLength(int length)
	{
		this.length = length;
	}
}
