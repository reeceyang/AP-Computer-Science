// Reece Yang
//
// This class models a point. It has instance fields for the x and y
// coordinate of the point, and a method to plot a "*" on a JFrame.

import java.awt.Graphics;

public class Point
{
	private int x;
	private int y;

	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public void drawPoint(Graphics g)
	{
		g.drawString("*", x, y);
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}
}