// Reece Yang
//
// This class is a subclass of the Worker class. It has instance fields for
// the number of hours worked, and has a Wage() method. The piece worker gets
// paid the hourly wage for all hours and income for all pieces completed.

public class PieceWorker extends Worker
{
	private int hoursWorked;
	private static final double PIECE_INCOME = 0.12;

	public PieceWorker (String name, double hourlyWageRate, int hoursWorked)
	{
		super(name, hourlyWageRate);
		this.hoursWorked = hoursWorked;
	}

	public double Wage(int pieces)
	{
		return super.computePay(hoursWorked) + computePay(pieces);
	}

	public double computePay(int numOfPieces)
	{
		return numOfPieces * PIECE_INCOME;
	}
}