// Reece Yang
//
// This class models a data set.

public class DataSet {

	private int sum;
	private int count;

	public DataSet() {

		sum = 0;
		count = 0;
	}

	public DataSet(int s, int c) {

		sum = s;
		count = c;
	}

	public int getSum() {

		return sum;
	}

	public int getCount() {

		return count;
	}

	public void addValue(int x) {

		sum += x;
		count++;
	}

	public double average() {

		return ((double) sum) / count;
	}
}