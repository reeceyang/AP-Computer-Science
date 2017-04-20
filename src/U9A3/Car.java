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
		int[] xCoords = {getInitX() + 5,
							getInitX() + 15,
							getInitX() + 15,
							getInitX() + 20,
							getInitX() + 20,
							getInitX(),
							getInitX(),
							getInitX() + 5};
		int[] yCoords = {getInitX(),
							getInitX(),
							getInitX() - 5,
							getInitX() - 5,
							getInitX() - 10,
							getInitX() - 10,
							getInitX() - 5,
							getInitX() - 5};
		g.drawPolygon(xCoords, yCoords, 8);
		g.drawLine(xCoords[7], yCoords[7], xCoords[2], yCoords[2]);
	}
}