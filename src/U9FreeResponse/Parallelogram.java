public class Parallelogram extends Quadrilateral
{
	private Point topLeft;
	private Point botLeft;
	private Point botRight;

	public Parallelogram(String lbl, Point tL, Point bL, Point bR)
	{
		super(lbl);
		topLeft = tL;
		botLeft = bL;
		botRight = bR;
	}
	public double perimeter()
	{
		double side1 = distance(topLeft, botLeft);
		double side2 = distance(botLeft, botRight);
		return 2 * (side1 + side2);
	}
	public double area()
	{
		double height = distance(new Point(botLeft.getX(), topLeft.getY()), botLeft);
        double base = distance(botLeft, botRight);
        return base * height;
	}
}
