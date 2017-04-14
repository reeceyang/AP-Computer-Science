// Reece Yang
//
// This is a driver class for the Card and Trick classes.
// It inputs five cards and determines the total number
// of points and the winner of the trick.

package U8A3;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class U8A3
{
    public static void main(String[] args)
    {
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            String string =
                    JOptionPane.showInputDialog(null, "Enter a card.");
            StringTokenizer st = new StringTokenizer(string);
            cards.add(new Card(st.nextToken(),
                    Integer.parseInt(st.nextToken())));
        }
        Trick trick = new Trick(cards);
        System.out.println("The Trick:\n");
        System.out.println(trick);
        System.out.println("Winning Card = " + trick.getWinner());
        System.out.println("\nPoints in Trick = " + trick.getTotalPoints());
    }
}
