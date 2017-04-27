// Reece Yang
//
// This class models a pitcher. It is a subclass of the BaseballPlayer class.
// It has instance fields for the innings pitched, earned runs, and the
// earned run average. It implements the setStat method.

public class Pitcher extends BaseballPlayer
{
	private double inningsPitched;
	private int earnedRuns;
	private String earnedRunAverage;

	public Pitcher(String name,
	               int games,
	               double inningsPitched,
	               int earnedRuns)
	{
		super(name, games);
		this.inningsPitched = inningsPitched;
		this.earnedRuns = earnedRuns;
		setStat();
	}

	public void setStat()
	{
		earnedRunAverage = String.format("%.2f",
		                                 (9 * earnedRuns) / inningsPitched);
	}

	public String toString()
	{
		return super.toString() +
		       "Earned Run Average: " + earnedRunAverage + "\n";
	}
}
