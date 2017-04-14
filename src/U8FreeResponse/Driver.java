import java.util.ArrayList;

public class Driver
{
	public static void main(String[] args)
	{
		Driver app = new Driver();
	}
	public Driver()
	{
		ArrayList<Comparable> list = new ArrayList<>();

		list.add(new Rectangle(5.2, 8.5));
		list.add(new Rectangle(3.9, 4.7));

		list.add(new RightTriangle(3.7, 5.1));
		list.add(new RightTriangle(1.8, 8.6));

		list.add(new Rectangle(3.9, 4.7));
		list.add(new RightTriangle(1.8, 8.6));

		list.add(new Rectangle(4, 5));
		list.add(new Rectangle(5, 4));

		list.add(new RightTriangle(3, 4));
		list.add(new RightTriangle(2, 6));

		for (int i = 0; i < list.size(); i += 2)
		{
			Comparable shape1 = list.get(i);
			Comparable shape2 = list.get(i + 1);
			int comparison = shape1.compareTo(shape2);
			if (comparison == 0)
			{
				System.out.println(getCompareText(comparison));
			}
			else
			{
				System.out.println(shape1 + getCompareText(comparison) + shape2);
			}
		}
	}
	public String getCompareText(int number)
	{
		if (number == 1)
		{
			return " is greater than ";
		}
		if (number == -1)
		{
			return " is less than ";
		}
		return "Shapes are equal";
	}
}


