// Reece Yang
//
// This Java project (applet) compares Merge Sort to the Quick Sort.

package U6A2;

import javax.swing.JApplet;
import javax.swing.JTextArea;
import java.awt.*;
import java.util.Random;

public class U6A2 extends JApplet
{
    private int[] mergeArray = new int[10000];
    private int[] quickArray = new int[10000];

    public void init()
    {
        setSize(1300, 700);
        JTextArea out = new JTextArea();
        out.setFont(new Font("Monospaced", Font.BOLD, 16));
        buildArrays();
        out.append("Unsorted Array\n\n");
        for (int i = 0; i < 15; i++)
        {
            out.append(mergeArray[i] + "\t");
        }
        out.append("\n");
        out.append("   .\n");
        out.append("   .\n");
        out.append("   .\n");
        for (int i = 9984; i < 9999; i++)
        {
            out.append(mergeArray[i] + "\t");
        }
        out.append("\n\n\n");
        out.append("MergeSort\n\n");
        MergeSorter mergeSorter = new MergeSorter(mergeArray);
        long begin = System.currentTimeMillis();
        mergeSorter.sort();
        long end = System.currentTimeMillis();
        long time = end - begin;
        mergeArray = mergeSorter.getArray();
        for (int i = 0; i < 15; i++)
        {
            out.append(mergeArray[i] + "\t");
        }
        out.append("\n");
        out.append("   .\n");
        out.append("   .\n");
        out.append("   .\n");
        for (int i = 9984; i < 9999; i++)
        {
            out.append(mergeArray[i] + "\t");
        }
        out.append("\n\n");
        out.append(time + " milliseconds\n\n\n");
        out.append("QuickSort\n\n");
        QuickSorter quickSorter = new QuickSorter(quickArray);
        begin = System.currentTimeMillis();
        quickSorter.sort(0, quickArray.length - 1);
        end = System.currentTimeMillis();
        time = end - begin;
        quickArray = quickSorter.getArray();
        for (int i = 0; i < 15; i++)
        {
            out.append(quickArray[i] + "\t");
        }
        out.append("\n");
        out.append("   .\n");
        out.append("   .\n");
        out.append("   .\n");
        for (int i = 9984; i < 9999; i++)
        {
            out.append(quickArray[i] + "\t");
        }
        out.append("\n\n");
        out.append(time + " milliseconds\n\n\n");
        Container container = getContentPane();
        container.add(out);
    }

    public void buildArrays()
    {
        Random r = new Random();
        for (int i = 0; i < 10000; i++)
        {
            int n = r.nextInt(1000);
            mergeArray[i] = n;
            quickArray[i] = n;
        }
    }
}
