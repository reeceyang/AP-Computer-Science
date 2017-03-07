package U7Test;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Container;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class u7test extends JFrame
{
    private ArrayList<BBPlayer> bbPlayers;
    private JTextArea out;

    public u7test()
    {
        out = new JTextArea();
        out.setFont(new Font("Monospaced", Font.BOLD, 16));

        bbPlayers = new ArrayList<>();
        try
        {
            Scanner reader = new Scanner(new File("src/U7Test/u7test.txt"));
            while (reader.hasNext())
            {
                String inputLine = reader.nextLine();
                bbPlayers.add(new BBPlayer(inputLine));
            }
            reader.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e.toString());
        }

        out.append(" Original List\n");
        out.append("\n");
        PrintList();
        out.append("\n\n\n");

        Sort();
        out.append(" Sorted List\n");
        out.append("\n");
        PrintList();

        Container container = getContentPane();
        container.add(out);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void PrintList()
    {
        out.append(" Number\tYear\tPosition\tPoint Per Game\n");
        out.append(" ------\t----\t--------\t--------------\n");
        int size = bbPlayers.size();
        for (int i = 0; i < size; i++)
        {
            BBPlayer bbPlayer = bbPlayers.get(i);
            out.append("   " + bbPlayer.getNum() + "\t"
                    + " " + bbPlayer.getYear() + "\t"
                    + "   " + bbPlayer.getPos() + "\t"
                    + "\t     " + bbPlayer.getPpg() + "\t");
            out.append("\n");
        }
    }
    public void Sort()
    {
        int j;
        BBPlayer temp;
        int length = bbPlayers.size();
        for (int n = 1; n < length; n++)
        {
            temp = bbPlayers.get(n);
            j = n;

            while (j > 0 && temp.getPpg() > bbPlayers.get(j - 1).getPpg())
            {
                bbPlayers.set(j, bbPlayers.get(j - 1));
                j--;
            }

            bbPlayers.set(j, temp);
        }
    }
    public static void main(String[] args)
    {
        u7test u7Test = new u7test();
    }
}
