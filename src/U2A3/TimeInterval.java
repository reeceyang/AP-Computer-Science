// Reece Yang
//
// This class will calculate pay for a
// time interval in military time

public class TimeInterval {

	private int hours;
	private int minutes;
	private double pay;

	public TimeInterval(String startingTime, String endingTime, double payRate) {

		/* Calculates the amount of minutes in the TimeInterval
		   by adding the minutes needed to get from the startingTime
		   to an hour, then adding the minutes over an hour from the endingTime,
		   and then multiplying the quantity the difference of the hour in the
		   endingTime and the hour + 1 in the startingTime by 60.
		*/
		int tempMinutes = (60 - Integer.parseInt(startingTime.substring(2)))
			+ Integer.parseInt(endingTime.substring(2))
			+ ((Integer.parseInt(endingTime.substring(0, 2))
			- (Integer.parseInt(startingTime.substring(0, 2)) + 1)) * 60);

		hours = (tempMinutes - (tempMinutes % 60)) / 60;
		minutes = tempMinutes % 60;
		pay = (((double) tempMinutes) / 60) * payRate;
	}

	public int getHours() {

		return hours;
	}

	public int getMinutes() {

		return minutes;
	}

	public double getPay() {

		return pay;
	}
}