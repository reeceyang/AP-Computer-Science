// Reece Yang
//
// This applet driver class places random numbers into arrays.

package U5A3;

import javax.swing.JApplet;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import java.awt.Container;

public class U5A3 extends JApplet {

    private JTextArea out = new JTextArea();
    private int[] n = new int[(int) (51 * Math.random() + 50)];

    public void init() {

        fillArray();
        out.append("Original Array\n\n");
        printArray(5);
        out.append("\nArray Length = " + n.length + "\n\n\n");
        nextFill();
        out.append("Updated Array\n\n");
        printArray(8);
        out.append("\nArray Length = " + n.length + "\n");

        Container c = getContentPane();
        c.add(out);
    }

    // fills array with 50 random integers
    public void fillArray() {

        for (int i = 0; i < 50; i++) {

            int number = (int) (5 * Math.random() + 5 * i);
            n[i] = number;
        }
    }

    // prints the array to the JTextArea
    public void printArray(int rows) {

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < 10; j++) {

                out.append(n[j + (i * 10)] + "\t");
            }
            out.append("\n");
        }
    }

    public void nextFill() {

        int dataSize = 50;
        for (int i = 0; i < 30; i++) {

            int number = (int) (256 * Math.random());
            orderedInsert(number, dataSize);
            dataSize++;
        }
    }

    // inserts a number in the array so it stays in order
    public void orderedInsert(int number, int dataSize) {

        int j = 0;
        boolean found = false;

        while ((j < dataSize) && (!found)) {

            if (number > n[j]) {

                j++;
            } else {

                found = true;
            }
        }

        try {

            insertAt(number, j, dataSize);
        } catch (RuntimeException e) {

            JOptionPane.showMessageDialog
                    (null, "Index out of Bounds - Resizing Array", "U5A2", JOptionPane.ERROR_MESSAGE);
            resize();
            insertAt(number, j, dataSize);
        }
    }

    // inserts number at index
    public void insertAt(int number, int index, int dataSize) {

        int size = n.length;
        for (int k = dataSize; k > index; k--) {

            n[k] = n[k - 1];
        }
        n[index] = number;
    }

    // resizes the array
    public void resize() {

        int newArray[] = new int[2 * n.length];
        System.arraycopy(n, 0, newArray, 0, n.length);
        n = newArray;
    }
}
