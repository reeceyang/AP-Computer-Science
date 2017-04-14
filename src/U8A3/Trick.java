// Reece Yang
//
// This card models a trick in the game of hearts.
// It has methods to get the total number of points
// and the winner.

package U8A3;

import java.util.ArrayList;

public class Trick
{
    private ArrayList<Card> cards;
    private int totalPoints;

    public Trick(ArrayList<Card> cards)
    {
        this.cards = cards;
        setTotalPoints();
    }

    private void setTotalPoints()
    {
        int size = cards.size();
        for (int i = 0; i < size; i++)
        {
            totalPoints += cards.get(i).getPoints();
        }
    }

    public Card getWinner()
    {
        Card winner;
        winner = cards.get(0);
        int size = cards.size();
        for (int i = 1; i < size; i++)
        {
            if (winner.compareTo(cards.get(i)) == -1
                    && winner.getSuit().equals(cards.get(i).getSuit()))
            {
                winner = cards.get(i);
            }
        }
        return winner;
    }

    public int getTotalPoints()
    {
        return totalPoints;
    }

    public String toString()
    {
        String string = "";
        int size = cards.size();
        for (int i = 0; i < size; i++)
        {
            string += cards.get(i) + "\n";
        }
        return string;
    }
}
