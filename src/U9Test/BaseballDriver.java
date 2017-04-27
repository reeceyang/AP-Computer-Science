// Reece Yang
//
// This is the driver class for the BaseballPlayer, Hitter, Fielder, and
// Pitcher classes. It fills an ArrayList with BaseballPlayer objects then
// prints out the contents of the ArrayList.

import java.util.ArrayList;

public class BaseballDriver
{
	public static void main(String[] args)
	{
		ArrayList<BaseballPlayer> baseballPlayers = new ArrayList<>();

		baseballPlayers.add(new Hitter("Tyler Lawson", 29, 78, 25));
		baseballPlayers.add(new Hitter("Jason Brown", 16, 54, 13));

		baseballPlayers.add(new Pitcher("Tom Jensen", 9, 50.7, 18));
		baseballPlayers.add(new Pitcher("Jason Brown", 10, 72.3, 15));

		baseballPlayers.add(new Fielder("Willie Starks", 30, 11, 97, 4));
		baseballPlayers.add(new Fielder("Jason Brown", 16, 23, 6, 3));

		for (BaseballPlayer baseballPlayer : baseballPlayers)
		{
			System.out.println(baseballPlayer);
		}
	}
}

/*

Name: Tyler Lawson
Games: 29
Batting Average: 0.321

Name: Jason Brown
Games: 16
Batting Average: 0.241

Name: Tom Jensen
Games: 9
Earned Run Average: 3.20

Name: Jason Brown
Games: 10
Earned Run Average: 1.87

Name: Willie Starks
Games: 30
Fielding Percentage: 0.964

Name: Jason Brown
Games: 16
Fielding Percentage: 0.906

*/