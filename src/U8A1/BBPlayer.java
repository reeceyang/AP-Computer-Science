// Reece Yang
//
// This class models a basketball player.

package U8A1;

import java.util.StringTokenizer;

public class BBPlayer implements Measurable
{
    private int num;
    private int year;
    private String pos;
    private double ppg;

    public BBPlayer(String string)
    {
        StringTokenizer st = new StringTokenizer(string);
        num = Integer.parseInt(st.nextToken());
        year = Integer.parseInt(st.nextToken());
        pos = st.nextToken();
        ppg = Double.parseDouble(st.nextToken());
    }

    public int getYear()
    {
        return year;
    }

    public int getNum()
    {
        return num;
    }

    public String getPos()
    {
        return pos;
    }

    public double getMeasure()
    {
        return ppg;
    }
}
