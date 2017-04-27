// Reece Yang
//
// This is a driver class for the Vehicle, Car, and Truck classes. It plots
// ten Vehicles with random positions on a JFrame.

import javax.swing.JFrame;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

public class U9A3 extends JFrame
{
	private ArrayList<Vehicle> list = new ArrayList<>();

	public U9A3()
	{
		super("Unit 9 Assignment 3");

		Container container = getContentPane();
		container.setBackground(Color.yellow);

		for (int i = 0; i < 10; i++)
		{
			if ((int) (Math.random() * 2) < 1)
			{
				list.add(new Truck((int) (Math.random() * 400),
					(int) (Math.random() * 400)));
			}
			else
			{
				list.add(new Car((int) (Math.random() * 400),
					(int) (Math.random() * 400)));
			}
		}

		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void paint(Graphics g)
	{
		super.paint(g);

		for (Vehicle vehicle : list)
		{
			vehicle.draw(g);
		}
	}

	public static void main(String[] args)
	{
		U9A3 u9a3 = new U9A3();
	}
}