// Reece Yang
//
// This class models a truck. It is a subclass of the Vehicle class. It has a
// parametric constructor and implements the draw method, which plots a
// "blue" truck.

import java.awt.Graphics;
import java.awt.Color;

public class Truck extends Vehicle
{
	public Truck(int initX, int initY)
	{
		super(initX, initY);
	}

	public void draw(Graphics g)
	{
		g.setColor(Color.blue);
		g.drawRect(getInitX(), getInitY() + 25, 25, 25);
		g.drawRect(getInitX() + 30, getInitY(), 75, 50);
		g.drawOval(getInitX(), getInitY() + 50, 12, 12);
		g.drawOval(getInitX() + 30, getInitY() + 50, 12, 12);
		g.drawOval(getInitX() + 42, getInitY() + 50, 12, 12);
		g.drawOval(getInitX() + 81, getInitY() + 50, 12, 12);
		g.drawOval(getInitX() + 93, getInitY() + 50, 12, 12);
	}
}