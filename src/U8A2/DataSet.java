// Reece Yang
//
// This class models a data set.

package U8A2;

public class DataSet
{
    private static double max;
    private static double min;
    private static double ave;
    private static double sum;
    private static int count;

    public DataSet()
    {
        max = 0;
        min = 0;
        ave = 0;
        sum = 0;
        count = 0;
    }

    public DataSet(Measurable x)
    {
        boolean flag = x.accept();
        if (flag)
        {
            double num = x.getMeasure();
            count++;
            sum += num;
            if (count == 1)
            {
                max = num;
                min = num;
            }
            else
            {
                if (num > max)
                {
                    max = num;
                }
                if (num < min)
                {
                    min = num;
                }
            }
            ave = sum / count;
        }
    }

    public double getMax()
    {
        return max;
    }
    public double getMin()
    {
        return min;
    }
    public double getAve()
    {
        return ave;
    }
}
