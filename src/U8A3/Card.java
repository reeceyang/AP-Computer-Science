// Reece Yang
//
// This class models a card.
// It has instance fields for the suit,
// value, and point values, and methods
// to compare two cards.

package U8A3;

public class Card implements Comparable
{
    private String suit;
    private int value;
    private int points;

    public Card(String suit, int value)
    {
        this.suit = suit;
        this.value = value;
        setPoints();
    }

    private void setPoints()
    {
        if (suit.equals("Hearts"))
        {
            points = 1;
        }
        else if (suit.equals("Spades") && value == 12)
        {
            points = 13;
        }
        else
        {
            points = 0;
        }
    }

    public int compareTo(Object object)
    {
        Card card = (Card) object;
        if (this.value > card.value)
        {
            return 1;
        }
        if (this.value < card.value)
        {
            return -1;
        }
        return 0;
    }

    public String toString()
    {
        String name = "" + value;
        if (value == 11)
        {
            name = "Jack";
        }
        if (value == 12)
        {
            name = "Queen";
        }
        if (value == 13)
        {
            name = "King";
        }
        if (value == 14)
        {
            name = "Ace";
        }
        return name + " of " + suit;
    }

    public String getSuit()
    {
        return suit;
    }

    public int getValue()
    {
        return value;
    }

    public int getPoints()
    {
        return points;
    }
}
