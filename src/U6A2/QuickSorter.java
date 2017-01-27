// Reece Yang
//
// This class uses quick sort to sort an array.

package U6A2;

public class QuickSorter
{
    private int[] a;

    public QuickSorter(int[] anArray)
    {
        a = anArray;
    }

    public void sort(int from, int to)
    {
        if (from >= to)
        {
            return;
        }

        int p = partition(from, to);
        sort(from, p);
        sort(p + 1, to);
    }

    private int partition(int from, int to)
    {
        int temp;
        int pivot = a[from];
        int i = from - 1;
        int j = to + 1;

        while (i < j)
        {
            i++;
            while (a[i] < pivot)
            {
                i++;
            }
            j--;
            while (a[j] > pivot)
            {
                j--;
            }
            if (i < j)
            {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        return j;
    }

    public int[] getArray()
    {
        return a;
    }
}
