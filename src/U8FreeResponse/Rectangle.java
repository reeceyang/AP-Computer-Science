public class Rectangle implements Shape, Comparable
{
	private double length;
	private double width;

	public Rectangle(double len, double wid)
	{
		length = len;
		width = wid;
	}

	public double area()
	{
		return length * width;
	}

	public double perimeter()
	{
		return 2 * length + 2 * width;
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
		return "Rectangle [" + length + ", " + width + "]";
	}
}