// Reece Yang
//
// This Java project (applet) compares Selection Sort to the Insertion Sort.

package U6A1;

import javax.swing.JApplet;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Container;
import java.util.Random;

public class U6A1 extends JApplet
{
    private int[] selectionArray = new int[10000];
    private int[] insertionArray = new int[10000];

    public void init()
    {
        setSize(1300, 700);
        JTextArea out = new JTextArea();
        out.setFont(new Font("Monospaced", Font.BOLD, 16));
        buildArrays();
        out.append("Unsorted Array\n\n");
        for (int i = 0; i < 15; i++)
        {
            out.append(selectionArray[i] + "\t");
        }
        out.append("\n");
        out.append("   .\n");
        out.append("   .\n");
        out.append("   .\n");
        for (int i = 9984; i < 9999; i++)
        {
            out.append(selectionArray[i] + "\t");
        }
        out.append("\n\n\n");
        out.append("After Selection Sort\n\n");
        long time = selectionSort();
        for (int i = 0; i < 15; i++)
        {
            out.append(selectionArray[i] + "\t");
        }
        out.append("\n");
        out.append("   .\n");
        out.append("   .\n");
        out.append("   .\n");
        for (int i = 9984; i < 9999; i++)
        {
            out.append(selectionArray[i] + "\t");
        }
        out.append("\n\n");
        out.append("Time = " + time + " milliseconds\n\n\n");
        out.append("After Insertion Sort\n\n");
        time = insertionSort();
        for (int i = 0; i < 15; i++)
        {
            out.append(insertionArray[i] + "\t");
        }
        out.append("\n");
        out.append("   .\n");
        out.append("   .\n");
        out.append("   .\n");
        for (int i = 9984; i < 9999; i++)
        {
            out.append(insertionArray[i] + "\t");
        }
        out.append("\n\n");
        out.append("Time = " + time + " milliseconds\n\n\n");
        Container container = getContentPane();
        container.add(out);
    }

    public long selectionSort()
    {
        long begin = System.currentTimeMillis();
        int minPos, temp;
        int length = selectionArray.length;
        for (int j = 0; j < length - 1; j++)
        {
            minPos = j;

            for (int k = j + 1; k < length; k++)
            {
                if (selectionArray[k] < selectionArray[minPos])
                {
                    minPos = k;
                }
            }
            temp = selectionArray[j];
            selectionArray[j] = selectionArray[minPos];
            selectionArray[minPos] = temp;
        }
        long end = System.currentTimeMillis();
        long time = end - begin;
        return time;
    }

    public long insertionSort()
    {
        long begin = System.currentTimeMillis();
        int j, temp;
        int length = insertionArray.length;
        for (int n = 1; n < length; n++)
        {
            temp = insertionArray[n];
            j = n;

            while (j > 0 && temp < insertionArray[j - 1])
            {
                insertionArray[j] = insertionArray[j - 1];
                j--;
            }

            insertionArray[j] = temp;
        }
        long end = System.currentTimeMillis();
        long time = end - begin;
        return time;
    }

    public void buildArrays()
    {
        Random r = new Random();
        for (int i = 0; i < 10000; i++)
        {
            int n = r.nextInt(1000);
            selectionArray[i] = n;
            insertionArray[i] = n;
        }
    }
}
