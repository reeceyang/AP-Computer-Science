package U5FreeResponse;

/**
 * Created by reyan21 on 1/18/2017.
 */
public class U5FreeResponse {
    public static void main(String[] args) {
        int[][] n = {{1,2,3,4,5,6,7,8,9},{2,4,6,8,10,12,14,16,18}};
        int[] a = rowSums(n);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println(isDiverse(new int[]{1,2,3,4,5,6,7,8,9,9}));
    }

    public static int[] rotate(int[] n) {
        int length = n.length;
        int[] m = new int[length];
        for (int i = 0; i < length; i++) {
            m[i] = n[(i - 1 + length) % length];
        }
        return m;
    }

    public static int arraySum(int[] n) {
        int sum = 0;
        for (int x : n) {
            sum += x;
        }
        return sum;
    }

    public static int[] rowSums(int[][] n) {
        int rows = n.length;
        int[] rowSums = new int[rows];
        for (int i = 0; i < rows; i++) {
            rowSums[i] = arraySum(n[i]);
        }
        return rowSums;
    }

    public static boolean isDiverse(int[] n) {
        int length = n.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (n[i] == n[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
