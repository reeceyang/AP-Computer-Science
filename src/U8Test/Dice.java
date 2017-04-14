// Reece Yang
//
// This class models two dice. It has methods to set
// and get the sum of two dice.

public class Dice implements Measurable
{
    private int die1;
    private int die2;
    private String sum;

    public Dice(int die1, int die2)
    {
        this.die1 = die1;
        this.die2 = die2;
        setSum();
    }

    private void setSum()
    {
        sum = "" + (die1 + die2);
    }

    public String getResult()
    {
        return sum;
    }
}
