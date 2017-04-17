// Reece Yang
//
// This class models a rectangle. It is a subclass of the Line class,
// and has an instance field for the width of the line, and a method
// to plot the rectangle on a JApplet.

import java.awt.Graphics;

public final class Rectangle extends Line
{
    private int width;

    public Rectangle(int x, int y, int length, int width)
    {
        super(x, y, length);
        this.width = width;
    }

    public void drawRect(Graphics g)
    {
        for (int i = 0; i < width; i++)
		{
			drawLine(g);
            setY(getY() + OFFSET);
            setX(getX() - getLength() * OFFSET);
		}
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }
}
