// Reece Yang
//
// This Java project (applet) will compare the Sequential Search to the
// Binary Search.

package U6A3;

import javax.swing.JApplet;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Container;

public class U6A3 extends JApplet
{
    private int[] array = new int[300];
    private int[] targets = {2, 2629, 11176, 27032, 43661};

    public void init()
    {
        setSize(1250, 750);
        JTextArea out = new JTextArea();
        out.setFont(new Font("Monospaced", Font.BOLD, 16));
        out.append("The Array\n\n");
        BuildArray();
        for (int i = 0; i < 20; i++)
        {
            for (int j = 0; j < 15; j++)
            {
                out.append(array[i * 15 + j] + "\t");
            }
            out.append("\n");
        }
        out.append("\n\n");
        out.append(
                "Search Comparisons using the # of visits to the Array\n\n");
        out.append("Number\tSequential\tBinary\n");
        out.append("------\t----------\t------\n");
        int numberOfTargets = targets.length;
        for (int i = 0; i < numberOfTargets; i++)
        {
            int target = targets[i];
            int sequentialVisits = Sequential(target);
            int binaryVisits = Binary(target);
            out.append(target
                    + "\t"
                    + (sequentialVisits == -1 ? "Not Found" : sequentialVisits + "\t")
                    + "\t"
                    + (binaryVisits == -1 ? "Not Found" : binaryVisits) + "\n");
        }
        Container container = getContentPane();
        container.add(out);
    }

    public void BuildArray()
    {
        for (int i = 0; i < 300; i++)
        {
            array[i] = (int) (i * i * 0.5 + i * 0.5 + 1);
        }
    }

    public int Sequential(int target)
    {
        int length = array.length;
        for (int i = 0; i < length; i++)
        {
            if (array[i] == target)
            {
                return i + 1;
            }
        }
        return -1;
    }

    public int Binary(int target)
    {
        int low = 0;
        int high = array.length - 1;
        int mid, dif, count = 0;

        while (low <= high)
        {
            count++;
            mid = (low + high) / 2;
            dif = array[mid] - target;

            if (dif == 0)
            {
                return count;
            }
            else if (dif < 0)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return -1;
    }
}
