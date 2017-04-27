// Reece Yang
//
// This is an abstract class that models a baseball player. It has
// a parametric constructor, a toString method, and an abstract setStat
// method.

public abstract class BaseballPlayer
{
	private String name;
	private int games;

	public BaseballPlayer(String name, int games)
	{
		this.name = name;
		this.games = games;
	}

	public abstract void setStat();

	public String toString()
	{
		return "Name: " + name + "\n" +
		       "Games: " + games + "\n";
	}
}