// Reece Yang
//
// This is an abstract super class that models a vehicle. It has instance
// fields for the initial position of the vehicle, a parametric constructor,
// methods to get the initial position of the vehicle, and an abstract method
// to draw the vehicle.

import java.awt.Graphics;

public abstract class Vehicle
{
	private int initX;
	private int initY;

	public Vehicle(int initX, int initY)
	{
		this.initX = initX;
		this.initY = initY;
	}

	public int getInitX()
	{
		return initX;
	}

	public int getInitY()
	{
		return initY;
	}

	public abstract void draw(Graphics g);
}