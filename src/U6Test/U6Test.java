// Reece Yang
//
// This Java project (applet) will sort an array of Strings in two ways.

package U6Test;

import javax.swing.JApplet;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Container;

public class U6Test extends JApplet
{
    private String[] a = {"Barr", "Chamberlain", "Fullam",
    "Gertler", "Jones", "Krantzler", "Ferguson", "Litchfield",
    "Johnson", "Sundeen", "Baker", "Celebucki", "Dunagan",
    "Eckert", "Framke", "Hoekstra", "Jackson", "Klupchak",
    "Kurtz", "Mahler", "Maxwell", "Rothermel", "Tarjan",
    "Tiller", "Turek"};

    private String[] alphabeticalArray = a.clone();
    private String[] lengthArray = a.clone();

    public void init()
    {
        setSize(500, 750);
        JTextArea out = new JTextArea();
        out.setFont(new Font("Monospaced", Font.BOLD, 16));
        alphabeticalArray = alphabeticalSort(alphabeticalArray);
        lengthArray = lengthSort(lengthArray);
        out.append("Sorted Alphabetically\tSorted by Length\n");
        out.append("---------------------\t----------------\n");
        for (int i = 0; i < a.length; i++)
        {
            out.append(alphabeticalArray[i]
                    + (alphabeticalArray[i].length() > 7 ? "\t\t" : "\t\t\t")
                    + lengthArray[i] + "\n");
        }
        out.append("\n");
        out.append("Jones at index "
        		+ binarySearch(alphabeticalArray, "Jones")
                + "\tJones at index "
                + sequentialSearch(lengthArray, "Jones"));
        Container container = getContentPane();
        container.add(out);
    }

    public String[] alphabeticalSort(String[] array)
    {
        int minPos;
        String temp;
        int length = array.length;
        for (int j = 0; j < length - 1; j++)
        {
            minPos = j;

            for (int k = j + 1; k < length; k++)
            {
                if (array[k].compareTo(array[minPos]) < 0)
                {
                    minPos = k;
                }
            }
            temp = array[j];
            array[j] = array[minPos];
            array[minPos] = temp;
        }
        return array;
    }

    public String[] lengthSort(String[] array)
    {
        array = alphabeticalSort(array);
        int minPos;
        String temp;
        int length = array.length;
        for (int j = 0; j < length - 1; j++)
        {
            minPos = j;

            for (int k = j + 1; k < length; k++)
            {
                if (array[k].length() < array[minPos].length())
                {
                    minPos = k;
                }
            }
            temp = array[j];
            array[j] = array[minPos];
            array[minPos] = temp;
        }
        return array;
    }

    public int sequentialSearch(String[] array, String target)
    {
        int length = array.length;
        for (int i = 0; i < length; i++)
        {
            if (array[i].equals(target))
            {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(String[] array, String target)
    {
        int low = 0;
        int high = array.length - 1;
        int mid, dif = 0;

        while (low <= high)
        {
            mid = (low + high) / 2;
            dif = array[mid].compareTo(target);

            if (dif == 0)
            {
                return mid;
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
