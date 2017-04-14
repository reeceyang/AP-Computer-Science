// Reece Yang
//
// This class tallies objects.
// It processes Measurable objects and returns a tally.

public class Tally
{
	private String[] item;
	private int[] tally;

	public Tally(String[] outcomes)
	{
		item = outcomes.clone();
		tally = new int[item.length];
	}

	public void process(Measurable x)
	{
		String result = x.getResult();
		int length = item.length;
		for (int i = 0; i < length; i++)
		{
			if (result.equals(item[i]))
			{
				tally[i]++;
				break;
			}
		}
	}

	public int[] getTally()
	{
		return tally;
	}
}
