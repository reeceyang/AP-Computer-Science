// Reece Yang
//
// This class models a hitter. It is a subclass of the BaseballPlayer class.
// It has instance fields for at bats, hits, and batting average. It
// implements the setStat method.

public class Hitter extends BaseballPlayer
{
	private int atBats;
	private int hits;
	private String battingAverage;

	public Hitter(String name, int games, int atBats, int hits)
	{
		super(name, games);
		this.atBats = atBats;
		this.hits = hits;
		setStat();
	}

	public void setStat()
	{
		battingAverage = String.format("%.3f", hits / (double) atBats);
	}

	public String toString()
	{
		return super.toString() +
		       "Batting Average: " + battingAverage + "\n";
	}
}