// Reece Yang
//
// This is a driver class for the Vehicle, Car, and Truck classes. It plots
// ten Vehicles with random positions on a JFrame.

import javax.swing.JFrame;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Color;

public class U9A3 extends JFrame
{
	public U9A3()
	{
		super("Unit 9 Assignment 3");

		Container container = getContentPane();
		container.setBackground(Color.yellow);

		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void paint(Graphics g)
	{
		super.paint(g);

		Car car = new Car(0, 0);
		car.draw(g);
	}

	public static void main(String[] args)
	{
		U9A3 u9a3 = new U9A3();
	}
}