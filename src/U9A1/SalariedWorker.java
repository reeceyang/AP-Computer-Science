// Reece Yang
//
// This class is a subclass of the Worker class. It has instance fields
// for the number of hours worked, and has a Wage() method. The
// salaried worker gets paid the hourly wage for 40 hours, no matter what.

public class SalariedWorker extends Worker
{
	private int hoursWorked;

	public SalariedWorker (String name, double hourlyWageRate, int hoursWorked)
	{
		super(name, hourlyWageRate);
		this.hoursWorked = hoursWorked;
	}

	public double Wage()
	{
		return super.computePay(40);
	}
}