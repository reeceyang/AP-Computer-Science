// Reece Yang
//
// This class models a fielder. It is a subclass of the BaseballPlayer class.
// It has instance fields for assists, putouts, errors, and
// fielding percentage. It implements the setStat method.

public class Fielder extends BaseballPlayer
{
	private int assists;
	private int putouts;
	private int errors;
	private String fieldingPercentage;

	public Fielder(String name, int games, int assists, int putouts, int errors)
	{
		super(name, games);
		this.assists = assists;
		this.putouts = putouts;
		this.errors = errors;
		setStat();
	}

	public void setStat()
	{
		double numerator = (double) assists + putouts;
		double denominator = numerator + errors;
		fieldingPercentage = String.format("%.3f", numerator / denominator);
	}

	public String toString()
	{
		return super.toString() +
		       "Fielding Percentage: " + fieldingPercentage + "\n";
	}
}