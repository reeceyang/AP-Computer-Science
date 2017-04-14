// Reece Yang
//
// This class models a worker. It has instance fields
// for the worker's name and hourly wage rate. It has
// methods to compute pay and to get the worker's name.

import java.util.StringTokenizer;

public class Worker
{
	private String name;
	private double hourlyWageRate;

	public Worker(String name, double hourlyWageRate)
	{
		this.name = name;
		this.hourlyWageRate = hourlyWageRate;
	}

	public double computePay(int hours)
	{
		return hours * hourlyWageRate;
	}

	public String getName()
	{
		StringTokenizer st = new StringTokenizer(name);
		String firstInitial = st.nextToken().substring(0, 1);
		String lastName = st.nextToken();
		return lastName + ", " + firstInitial + ".";
	}
}