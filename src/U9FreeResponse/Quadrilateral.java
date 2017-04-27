public abstract class Quadrilateral
{
	private String label;

	public Quadrilateral(String lbl)
	{
		label = lbl;
	}

	public String getLabel()
	{
		return label;
	}

	protected double distance(Point one, Point two)
	{
		int x1 = one.getX();
		int y1 = one.getY();
		int x2 = two.getX();
		int y2 = two.getY();
		double ans = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
		return ans;
	}

	public abstract double perimeter();
	public abstract double area();
}