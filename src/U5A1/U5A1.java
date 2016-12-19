// Reece Yang
//
// This driver class calculates the mean, standard deviation, and correlation
// of AP Exam scores and grades.

public class U5A1 {

	public U5A1() {

		int[] apExam = {4,5,5,5,3,2,5,4,5,4,3,4,5,4,4,5,4};
		int[] grades = {5,5,5,5,4,4,5,3,5,4,4,5,5,4,4,5,4};

		double meanApExam = mean(apExam);
		double meanGrades = mean(grades);

		double sDevApExam = standardDev(apExam);
		double sDevGrades = standardDev(grades);

		double correlation = correlation(apExam, grades);

		System.out.printf("Mean of AP Exams = %.2f\n", meanApExam);
		System.out.printf("Mean of Grades   = %.2f\n", meanGrades);
		System.out.println();
		System.out.printf(
			"Standard Deviation of AP Exams = %.2f\n", sDevApExam);
		System.out.printf(
			"Standart Deviation of Grades   = %.2f\n", sDevGrades);
		System.out.println();
		System.out.printf("Correlation = %.2f\n", correlation);
	}
	public double mean(int[] x) {

		int n = x.length;
		int sum = 0;
		for (int i : x) {

			sum += i;
		}
		return ((double) sum) / n;
	}
	public double standardDev(int[] x) {

		int n = x.length;
		double meanX = mean(x);
		double sum = 0;
		for (int i : x) {

			sum += (i - meanX) * (i - meanX);
		}
		return Math.sqrt(sum / n);
	}
	public double correlation(int[] x, int[] y) {

		double meanX = mean(x);
		double meanY = mean(y);
		double Sx = standardDev(x);
		double Sy = standardDev(y);

		int n = x.length;
		double sum = 0;
		for (int i = 0; i < n; i++) {

			double numerator = (x[i] - meanX) * (y[i] - meanY);
			double denominator = (n - 1) * Sx * Sy;
			sum += numerator / denominator;
		}

		return sum;
	}
	public static void main(String[] args) {

		U5A1 u5a1 = new U5A1();
	}
}

/*

Mean of AP Exams = 4.18
Mean of Grades   = 4.47

Standard Deviation of AP Exams = 0.86
Standart Deviation of Grades   = 0.61

Correlation = 0.67

*/