// Reece Yang
//
// This is a driver class.

package U8A1;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Container;
import java.awt.Font;
import java.io.*;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.Scanner;

public class U8A1 extends JFrame
{
    private JTextArea output = new JTextArea();

    public static void main(String args[])
    {
        U8A1 x = new U8A1();
        x.setSize(300, 500);
        x.setVisible(true);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public U8A1()
    {
        TestBBPlayer();
        TestBankAccount();
    }

    public void TestBBPlayer()
    {
        String input;
        DataSet z = new DataSet();
        try
        {
            Scanner in = new Scanner(new File("src/U8A1/u7test.txt"));
            for (int i = 0; i < 5; i++)
            {
                input = in.nextLine();
                BBPlayer aPlayer = new BBPlayer(input);
                z = new DataSet(aPlayer);
            }
            in.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e.toString());
        }
        Container container = getContentPane();
        output.setFont(new Font("Monospaced", Font.BOLD, 14));
        output.setText("BBPlayer Stats\n");
        output.append("--------------\n\n");
        double bbmin, bbmax, bbave;
        bbmin = z.getMin();
        bbmax = z.getMax();
        bbave = z.getAve();

        output.append("Minimum Points Per Game = " + bbmin + "\n\n");
        output.append("Maximum Points Per Game = " + bbmax + "\n\n");
        output.append("Average Points Per Game = " + bbave + "\n\n");
        container.add(output);
    }

    public void TestBankAccount()
    {
        String num, sbal;
        double bal;
        DataSet z = new DataSet();
        try
        {
            Scanner in = new Scanner(new File("src/U8A1/myCreditUnion.txt"));
            while (in.hasNext())
            {
                String line = in.nextLine();
                StringTokenizer tokenizer = new StringTokenizer(line);
                num = tokenizer.nextToken();
                sbal = tokenizer.nextToken();
                bal = Double.parseDouble(sbal);
                BankAccount anAccount = new BankAccount(num, bal);
                z = new DataSet(anAccount);
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e.toString());
        }
        output.append("\nBankAccount Stats\n");
        output.append("-----------------\n\n");
        double bamin, bamax, baave;
        bamin = z.getMin();
        bamax = z.getMax();
        baave = z.getAve();
        output.append("Minimum Bank Account = " + bamin + "\n\n");
        output.append("Maximum Bank Account = " + bamax + "\n\n");
        String x = String.format("%.2f", baave);
        output.append("Average Bank Account = " + x + "\n\n");
    }
}
