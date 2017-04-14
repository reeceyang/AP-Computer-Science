public class RightTriangle implements Shape, Comparable
{
	private double leg1;
	private double leg2;

	public RightTriangle(double x, double y)
	{
		leg1 = x;
		leg2 = y;
	}

	public double area()
	{
		return leg1 * leg2 * 0.5;
	}

	public double perimeter()
	{
		return leg1 + leg2 + Math.sqrt(leg1 * leg1 + leg2 * leg2);
	}

	public int compareTo(Object obj)
	{
		Shape shape = (Shape) obj;
		if (shape.area() < this.area())
		{
			return 1;
		}
		if (shape.area() > this.area())
		{
			return -1;
		}
		if (shape.perimeter() < this.perimeter())
		{
			return 1;
		}
		if (shape.perimeter() > this.perimeter())
		{
			return -1;
		}
		return 0;
	}

	public String toString()
	{
		return "Right Triangle[" + leg1 + ", " + leg2 + "]";
	}
}