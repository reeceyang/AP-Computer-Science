// Reece Yang
//
// This class is a subclass of the Worker class. It has instance
// fields for the number of hours worked, and has a Wage() method.
// The hourly worker gets paid at time and a half for overtime.

public class HourlyWorker extends Worker
{
	private int hoursWorked;

	public HourlyWorker (String name, double hourlyWageRate, int hoursWorked)
	{
		super(name, hourlyWageRate);
		this.hoursWorked = hoursWorked;
	}

	public double Wage()
	{
		if (hoursWorked > 40)
		{
			return super.computePay(40) + super.computePay(hoursWorked - 40) * 1.5;
		}
		else
		{
			return super.computePay(hoursWorked);
		}
	}
}