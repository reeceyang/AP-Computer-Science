public class Trapezoid extends Quadrilateral
{
    private Point topLeft;
    private Point botLeft;
    private Point botRight;
    private Point topRight;

    public Trapezoid(String lbl, Point tL, Point bL, Point bR, Point tR)
    {
        super(lbl);
        topLeft = tL;
        botLeft = bL;
        botRight = bR;
        topRight = tR;
    }

    public double perimeter()
    {
        double side1 = distance(topLeft, botLeft);
        double side2 = distance(botLeft, botRight);
        double side3 = distance(botRight, topRight);
        double side4 = distance(topRight, topLeft);
        return side1 + side2 + side3 + side4;
    }

    public double area()
    {
        // Top is parallel to bottom
        if ((topLeft.getY() - topRight.getY()) * (botLeft.getX() - botRight.getX()) ==
            (topLeft.getX() - topRight.getX()) * (botLeft.getY() - botRight.getY()))
        {
            double base1 = distance(topLeft, topRight);
            double base2 = distance(botLeft, botRight);
            double height = distance(new Point(botLeft.getX(), topLeft.getY()), botLeft);
            return 0.5 * height * (base1 + base2);
        }
        // Right is parallel to left
        else
        {
            double base1 = distance(topLeft, botLeft);
            double base2 = distance(topRight, botRight);
            double height = distance(new Point(botLeft.getX(), botRight.getY()), botRight);
            return 0.5 * height * (base1 + base2);
        }
    }
}
