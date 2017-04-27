// Reece Yang
//
// This class models a car. It is a subclass of the Vehicle class, and has a
// parametric constructor and a draw method that plots a red car.

import java.awt.Graphics;
import java.awt.Color;

public class Car extends Vehicle
{
	public Car(int initX, int initY)
	{
		super(initX, initY);
	}

	public void draw(Graphics g)
	{
		g.setColor(Color.red);
		g.drawRect(getInitX() + 12, getInitY(), 25, 12);
		g.drawRect(getInitX(), getInitY() + 12, 50, 12);
		g.drawOval(getInitX(), getInitY() + 25, 12, 12);
		g.drawOval(getInitX() + 37, getInitY() + 25, 12, 12);
	}
}