// Reece Yang
//
// This class uses merge sort to sort an array.

package U6A2;

public class MergeSorter
{
    private int[] a;

    public MergeSorter(int[] anArray)
    {
        a = anArray;
    }

    public void sort()
    {
        if (a.length <= 1)
        {
            return;
        }

        int[] first = new int[a.length / 2];
        int[] second = new int[a.length - first.length];

        System.arraycopy(a, 0, first, 0, first.length);
        System.arraycopy(a, first.length, second, 0, second.length);

        MergeSorter firstSorter = new MergeSorter(first);
        MergeSorter secondSorter = new MergeSorter(second);

        firstSorter.sort();
        secondSorter.sort();
        merge(first, second);
    }

    public void merge(int[] first, int[] second)
    {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < first.length && j < second.length)
        {
            if (first[i] < second[j])
            {
                a[k] = first[i];
                i++;
            }
            else
            {
                a[k] = second[j];
                j++;
            }
            k++;
        }

        System.arraycopy(first, i, a, k, first.length - i);
        System.arraycopy(second, j, a, k, second.length - j);
    }

    public int[] getArray()
    {
        return a;
    }
}
